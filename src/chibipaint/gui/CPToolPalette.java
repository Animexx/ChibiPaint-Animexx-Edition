/*
	ChibiPaint
    Copyright (c) 2006-2008 Marc Schefer

    This file is part of ChibiPaint.

    ChibiPaint is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ChibiPaint is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ChibiPaint. If not, see <http://www.gnu.org/licenses/>.

 */

package chibipaint.gui;

import java.awt.*;
import java.awt.event.*;

import chibipaint.*;

public class CPToolPalette extends CPPalette implements ActionListener {

	public CPToolPalette(CPController controller) {
		super(controller);

		title = "Tools";
		setLayout(new FlowLayout());

		Image icons = controller.loadImage("icons.png");
		CPIconButton button;

		button = new CPIconButton(icons, 32, 32, 0, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPRectSelection");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_rect"));

		button = new CPIconButton(icons, 32, 32, 1, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPMoveTool");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_move"));

		button = new CPIconButton(icons, 32, 32, 2, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPFloodFill");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_fill"));

		button = new CPIconButton(icons, 32, 32, 29, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPRotateCanvas");
		button.setCPActionCommandDouble("CPResetCanvasRotation");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_rotate"));

		button = new CPIconButton(icons, 32, 32, 5, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPPencil");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_pencil"));

		button = new CPIconButton(icons, 32, 32, 6, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPPen");
		button.setSelected(true);
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_pen"));

		button = new CPIconButton(icons, 32, 32, 7, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPAirbrush");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_airbrush"));

		button = new CPIconButton(icons, 32, 32, 18, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPWater");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_watercolor"));

		button = new CPIconButton(icons, 32, 32, 8, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPEraser");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_eraser"));

		button = new CPIconButton(icons, 32, 32, 9, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPSoftEraser");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_eraser_soft"));

		button = new CPIconButton(icons, 32, 32, 24, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPSmudge");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_smudge"));

		button = new CPIconButton(icons, 32, 32, 28, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPBlender");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_blender"));

		button = new CPIconButton(icons, 32, 32, 16, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPDodge");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_dodge"));

		button = new CPIconButton(icons, 32, 32, 17, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPBurn");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_burn"));

		button = new CPIconButton(icons, 32, 32, 23, 1);
		add(button);

		button.addCPActionListener(controller);
		button.addCPActionListener(this);
		button.setCPActionCommand("CPBlur");
                button.setToolTipText(CPMainGUI.language.getString("tool_tip_blur"));

	}

	public void actionPerformed(ActionEvent e) {
		Component[] components = getComponents();
		for (Component c : components) {
			if (c != e.getSource()) {
				((CPIconButton) c).setSelected(false);
			}
		}

		((CPIconButton) e.getSource()).setSelected(true);
	}
}
