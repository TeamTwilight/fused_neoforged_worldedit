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

package com.sk89q.worldedit.util.auth;

import com.sk89q.worldedit.WorldEditException;
import net.kyori.text.Component;

/**
 * Raised when authorization is not granted.
 */
public class AuthorizationException extends WorldEditException {

    public AuthorizationException() {
    }

    public AuthorizationException(Component message) {
        super(message);
    }

    @Deprecated
    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(Component message, Throwable cause) {
        super(message, cause);
    }

    @Deprecated
    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }
}
