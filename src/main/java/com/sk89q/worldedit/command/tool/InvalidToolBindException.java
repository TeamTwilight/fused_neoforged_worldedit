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

package com.sk89q.worldedit.command.tool;

import com.sk89q.worldedit.WorldEditException;
import net.kyori.text.Component;
import com.sk89q.worldedit.world.item.ItemType;

public class InvalidToolBindException extends WorldEditException {

    private final ItemType item;

    public InvalidToolBindException(ItemType item, Component msg) {
        super(msg);
        this.item = item;
    }

    @Deprecated
    public InvalidToolBindException(ItemType item, String msg) {
        super(msg);
        this.item = item;
    }

    public ItemType getItemType() {
        return this.item;
    }

}
