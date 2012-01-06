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
import java.text.*;

import javax.swing.*;

import chibipaint.*;
import chibipaint.engine.*;
import javax.swing.border.Border;

public class CPStatusBar extends JPanel implements CPController.ICPViewListener, CPController.ICPEventListener {

	CPController controller;
	JLabel memory, zoom, editing_time;

	public CPStatusBar(CPController controller) {
		super(new BorderLayout());
		this.controller = controller;

                editing_time = new JLabel(CPMainGUI.language.getString("status_edit_time") + ": 0:00");
                editing_time.setHorizontalAlignment(JLabel.CENTER);
                add(editing_time, BorderLayout.CENTER);

		zoom = new JLabel(CPMainGUI.language.getString("status_edit_zoom") + ": 100%");
		add(zoom, BorderLayout.WEST);
                
		memory = new JLabel("");
		add(memory, BorderLayout.EAST);
                
		memory.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Runtime r = Runtime.getRuntime();
					r.gc();
				}
			}
		});
                
		updateMemory();
		controller.addViewListener(this);
		// controller.addCPEventListener(this);

		Timer timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateMemory();
                                updateEditTime();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}

	public void viewChange(CPController.CPViewInfo viewInfo) {
		DecimalFormat format = new DecimalFormat("0.0%");
		zoom.setText(CPMainGUI.language.getString("status_edit_zoom") + ": " + format.format(viewInfo.zoom));
	}

        public void updateEditTime() {
            int seconds = controller.getEditingTime();
            String display = CPMainGUI.language.getString("status_edit_time") + ": ";
            Integer display_minutes = (int)Math.floor(seconds / 60);
            Integer display_seconds = (int)(seconds % 60);
            display += display_minutes.toString() + ":";
            if (display_seconds >= 10) display += display_seconds.toString();
            else display += "0" + display_seconds.toString();
            editing_time.setText(display);
        }
	public void updateMemory() {
		DecimalFormat format = new DecimalFormat("0.0");

		Runtime rt = java.lang.Runtime.getRuntime();
		float maxMemory = rt.maxMemory() / (1024f * 1024f);
		float totalUsed = (rt.totalMemory() - rt.freeMemory()) / (1024f * 1024f);
		float docMem = 0;
		float undoMem = 0;

		CPArtwork artwork = controller.getArtwork();
		if (artwork != null) {
			docMem = artwork.getDocMemoryUsed() / (1024f * 1024f);
			undoMem = artwork.getUndoMemoryUsed() / (1024f * 1024f);
		}

		if ((docMem + undoMem) / maxMemory > .5) {
			memory.setForeground(Color.RED);
		} else {
			memory.setForeground(Color.BLACK);
		}
                String zerofiller = "";
                if (totalUsed < 10) zerofiller = "0";

		memory.setText(CPMainGUI.language.getString("status_edit_mem") +
                        ": " + zerofiller + format.format(totalUsed) + "/" + format.format(maxMemory) + ",D"
				+ format.format(docMem) + " U" + format.format(undoMem));
	}

	public void cpEvent() {
		updateMemory();
	}
}
