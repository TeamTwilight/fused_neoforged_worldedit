/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.regions.shape;

import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.internal.expression.ExpressionEnvironment;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.world.registry.LegacyMapper;

public class WorldEditExpressionEnvironment implements ExpressionEnvironment {

    private final Vector3 unit;
    private final Vector3 zero2;
    private Vector3 current = Vector3.ZERO;
    private final Extent extent;

    public WorldEditExpressionEnvironment(Extent extent, Vector3 unit, Vector3 zero) {
        this.extent = extent;
        this.unit = unit;
        this.zero2 = zero.add(0.5, 0.5, 0.5);
    }

    public BlockVector3 toWorld(double x, double y, double z) {
        // unscale, unoffset, round-nearest
        return Vector3.at(x, y, z).multiply(unit).add(zero2).toBlockPoint();
    }

    public Vector3 toWorldRel(double x, double y, double z) {
        return current.add(x, y, z);
    }

    private int getLegacy(BlockVector3 position, int index) {
        final int[] legacy = LegacyMapper.getInstance().getLegacyFromBlock(extent.getBlock(position).toImmutableState());
        return legacy == null ? 0 : legacy[index];
    }

    @Override
    public int getBlockType(double x, double y, double z) {
        return getLegacy(toWorld(x, y, z), 0);
    }

    @Override
    public int getBlockData(double x, double y, double z) {
        return getLegacy(toWorld(x, y, z), 1);
    }

    @Override
    public int getBlockTypeAbs(double x, double y, double z) {
        return getLegacy(BlockVector3.at(x, y, z), 0);
    }

    @Override
    public int getBlockDataAbs(double x, double y, double z) {
        return getLegacy(BlockVector3.at(x, y, z), 1);
    }

    @Override
    public int getBlockTypeRel(double x, double y, double z) {
        return getLegacy(toWorldRel(x, y, z).toBlockPoint(), 0);
    }

    @Override
    public int getBlockDataRel(double x, double y, double z) {
        return getLegacy(toWorldRel(x, y, z).toBlockPoint(), 1);
    }

    public void setCurrentBlock(Vector3 current) {
        this.current = current;
    }

}
