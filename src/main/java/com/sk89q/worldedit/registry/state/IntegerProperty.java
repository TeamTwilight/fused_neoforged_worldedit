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

package com.sk89q.worldedit.registry.state;

import javax.annotation.Nullable;
import java.util.List;

public class IntegerProperty extends AbstractProperty<Integer> {

    public IntegerProperty(final String name, final List<Integer> values) {
        super(name, values);
    }

    @Nullable
    @Override
    public Integer getValueFor(String string) {
        try {
            int val = Integer.parseInt(string);
            if (!getValues().contains(val)) {
                throw new IllegalArgumentException("Invalid int value: " + string + ". Must be in " + getValues().toString());
            }
            return val;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid int value: " + string + ". Not an int.");
        }
    }
}
