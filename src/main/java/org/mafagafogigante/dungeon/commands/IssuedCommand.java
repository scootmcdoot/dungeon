/*
 * Copyright (C) 2014 Bernardo Sulzbach
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mafagafogigante.dungeon.commands;

import org.mafagafogigante.dungeon.util.Utils;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * IssuedCommand class that processes a command entered by the player and provides useful query methods.
 *
 * <p>IssuedCommands are case-unsensitive and granted to have at least one word (the command).
 */
public final class IssuedCommand {

  private final String stringRepresentation;
  private final List<String> tokens; // An unmodifiable list.

  /**
   * Creates a new IssuedCommand from a string.
   *
   * @param source a string with at least one character that is not whitespace.
   */
  public IssuedCommand(@NotNull String source) {
    tokens = Collections.unmodifiableList(Arrays.asList(Utils.split(source)));
    if (tokens.isEmpty()) {
      throw new IllegalArgumentException("invalid source, no tokens obtained.");
    }
    this.stringRepresentation = StringUtils.join(tokens, ' ');
  }

  public String getStringRepresentation() {
    return stringRepresentation;
  }

  /**
   * Returns an unmodifiable view of the list of tokens.
   */
  public List<String> getTokens() {
    return tokens; // tokens is already unmodifiable.
  }

  @Override
  public String toString() {
    return getStringRepresentation();
  }

}
