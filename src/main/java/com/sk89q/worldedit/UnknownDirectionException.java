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

package com.sk89q.worldedit;

import net.kyori.text.TextComponent;
import net.kyori.text.TranslatableComponent;

/**
 * Thrown when an unknown direction is specified or detected.
 */
public class UnknownDirectionException extends WorldEditException {

    private final String dir;

    /**
     * Create a new instance.
     *
     * @param dir the input that was tried
     */
    public UnknownDirectionException(String dir) {
        super(TranslatableComponent.of("worldedit.error.unknown-direction", TextComponent.of(dir)));
        this.dir = dir;
    }

    /**
     * Get the direction string that was input.
     *
     * @return input
     */
    public String getDirection() {
        return dir;
    }

}
