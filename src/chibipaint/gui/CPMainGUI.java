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
import java.util.*;

import javax.swing.*;

import chibipaint.*;

public class CPMainGUI {

	CPController controller;
	CPPaletteManager paletteManager;

	JMenuBar menuBar;
	JPanel mainPanel;
	JDesktopPane jdp;
	JPanel bg;

	// FIXME: replace this hack by something better
	Map<String, JCheckBoxMenuItem> paletteItems = new HashMap();
        
        public static CPLanguage language;
        
	public CPMainGUI(CPController controller, String languageStr) {
		this.controller = controller;
		controller.setMainGUI(this);

                language = CPLanguage.getLanguageClass(languageStr);
                
		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (Exception ex2) {} */

		menuBar = createMainMenu(controller);
		createGUI();
	}

	public JComponent getGUI() {
		return mainPanel;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	private void createGUI() {
		mainPanel = new JPanel(new BorderLayout());

		jdp = new CPDesktop();
		paletteManager = new CPPaletteManager(controller, jdp);

		createCanvasGUI(jdp);
		mainPanel.add(jdp, BorderLayout.CENTER);

		JPanel statusBar = new CPStatusBar(controller);
		mainPanel.add(statusBar, BorderLayout.PAGE_END);

		// jdp.addContainerListener(this);
	}

	void createCanvasGUI(JComponent c) {
		CPCanvas canvas = new CPCanvas(controller);
		bg = canvas.getContainer();

		c.add(bg);
		canvas.grabFocus();
	}

	private JMenuBar createMainMenu(ActionListener listener) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu, submenu;
		JMenuItem menuItem;

		//
		// File Menu
		//

		menu = new JMenu(language.getString("menu_file"));
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		if (controller.isRunningAsApplet()) {
			menuItem = new JMenuItem(language.getString("send_oekaki"), KeyEvent.VK_V);
			menuItem.getAccessibleContext().setAccessibleDescription(language.getString("send_oekaki_hint"));
			menuItem.setActionCommand("CPSend");
			menuItem.addActionListener(listener);
			menu.add(menuItem);
		}

		//
		// Edit Menu
		//

		menu = new JMenu(language.getString("menu_edit"));
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);

		menuItem = new JMenuItem(language.getString("undo"), KeyEvent.VK_U);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("undo_hint"));
		menuItem.setActionCommand("CPUndo");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("redo"), KeyEvent.VK_R);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("redo_hint"));
		menuItem.setActionCommand("CPRedo");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("clear_memory"), KeyEvent.VK_H);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("clear_memory_hint"));
		menuItem.setActionCommand("CPClearHistory");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menu.add(new JSeparator());

		menuItem = new JMenuItem(language.getString("cut"), KeyEvent.VK_T);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setActionCommand("CPCut");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("copy"), KeyEvent.VK_C);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setActionCommand("CPCopy");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("copy_merged"), KeyEvent.VK_Y);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setActionCommand("CPCopyMerged");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("paste"), KeyEvent.VK_P);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setActionCommand("CPPaste");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menu.add(new JSeparator());

		menuItem = new JMenuItem(language.getString("select_all"), KeyEvent.VK_A);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("select_all_hint"));
		menuItem.setActionCommand("CPSelectAll");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("deselect"), KeyEvent.VK_D);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("deselect_hint"));
		menuItem.setActionCommand("CPDeselectAll");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menu = new JMenu(language.getString("menu_layers"));
		menu.setMnemonic(KeyEvent.VK_L);
		menuBar.add(menu);

		menuItem = new JMenuItem(language.getString("duplicate"), KeyEvent.VK_D);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("duplicate_hint"));
		menuItem.setActionCommand("CPLayerDuplicate");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		menu.add(menuItem);

		menu.add(new JSeparator());

		menuItem = new JMenuItem(language.getString("merge_down"), KeyEvent.VK_E);
		menuItem.getAccessibleContext().setAccessibleDescription(
				language.getString("merge_down_hint"));
		menuItem.setActionCommand("CPLayerMergeDown");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		/*
		 * menuItem = new JMenuItem("Merge Visible", KeyEvent.VK_V);
		 * menuItem.getAccessibleContext().setAccessibleDescription("Merges all the visible layers");
		 * menuItem.setActionCommand("CPLayerMergeVisible"); menuItem.addActionListener(listener);
		 * menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK |
		 * ActionEvent.SHIFT_MASK)); menu.add(menuItem);
		 */

		menuItem = new JMenuItem(language.getString("merge_visible"), KeyEvent.VK_A);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("merge_visible_hint"));
		menuItem.setActionCommand("CPLayerMergeAll");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		//
		// Effects Menu
		//
		menu = new JMenu(language.getString("menu_effects"));
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);

		menuItem = new JMenuItem(language.getString("clear"), KeyEvent.VK_C);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("clear_hint"));
		menuItem.setActionCommand("CPClear");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("fill"), KeyEvent.VK_F);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("fill_hint"));
		menuItem.setActionCommand("CPFill");
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("flip_h"), KeyEvent.VK_H);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("flip_h_hint"));
		menuItem.setActionCommand("CPHFlip");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("flip_v"), KeyEvent.VK_V);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("flip_v_hint"));
		menuItem.setActionCommand("CPVFlip");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("invert"), KeyEvent.VK_I);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("invert_h"));
		menuItem.setActionCommand("CPFXInvert");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		submenu = new JMenu(language.getString("blur"));
		submenu.setMnemonic(KeyEvent.VK_B);

		menuItem = new JMenuItem(language.getString("box_blur"), KeyEvent.VK_B);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("box_blur_hint"));
		menuItem.setActionCommand("CPFXBoxBlur");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);

		menu.add(submenu);

		submenu = new JMenu(language.getString("menu_noise"));
		submenu.setMnemonic(KeyEvent.VK_N);

		menuItem = new JMenuItem(language.getString("render_mono"), KeyEvent.VK_M);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("render_mono_hint"));
		menuItem.setActionCommand("CPMNoise");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);

		menuItem = new JMenuItem(language.getString("render_color"), KeyEvent.VK_C);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("render_color_hint"));
		menuItem.setActionCommand("CPCNoise");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);

		menu.add(submenu);

		//
		// View Menu
		//

		menu = new JMenu(language.getString("menu_view"));
		menu.setMnemonic(KeyEvent.VK_V);
		menuBar.add(menu);

		if (controller.isRunningAsApplet()) {
			menuItem = new JMenuItem(language.getString("floating_mode"), KeyEvent.VK_F);
			menuItem.getAccessibleContext().setAccessibleDescription(language.getString("floating_mode_hint"));
			menuItem.setActionCommand("CPFloat");
			menuItem.addActionListener(listener);
			menu.add(menuItem);
			menu.add(new JSeparator());
		}

		menuItem = new JMenuItem(language.getString("zoom_in"), KeyEvent.VK_I);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("CPZoomIn");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("zoom_out"), KeyEvent.VK_O);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("CPZoomOut");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("zoom_100"), KeyEvent.VK_1);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("zoom_100_hint"));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("CPZoom100");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menu.add(new JSeparator());

		menuItem = new JCheckBoxMenuItem(language.getString("linear_int"), false);
		menuItem.setMnemonic(KeyEvent.VK_L);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("linear_int_hint"));
		menuItem.setActionCommand("CPLinearInterpolation");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menu.add(new JSeparator());

		menuItem = new JCheckBoxMenuItem(language.getString("show_grid"), false);
		menuItem.setMnemonic(KeyEvent.VK_G);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("show_grid_hint"));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("CPToggleGrid");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menuItem = new JMenuItem(language.getString("grid_opt"), KeyEvent.VK_D);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("grid_opt_hint"));
		menuItem.setActionCommand("CPGridOptions");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		menu.add(new JSeparator());

		submenu = new JMenu(language.getString("menu_palettes"));
		submenu.setMnemonic(KeyEvent.VK_P);

		menuItem = new JMenuItem(language.getString("toggle_palettes"), KeyEvent.VK_P);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("toggle_palettes_hint"));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0));
		menuItem.setActionCommand("CPTogglePalettes");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);

		submenu.add(new JSeparator());

		menuItem = new JCheckBoxMenuItem(language.getString("show_brush"), true);
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.setActionCommand("CPPalBrush");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Brush", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_color"), true);
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.setActionCommand("CPPalColor");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Color", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_layers"), true);
		menuItem.setMnemonic(KeyEvent.VK_Y);
		menuItem.setActionCommand("CPPalLayers");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Layers", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_misc"), true);
		menuItem.setMnemonic(KeyEvent.VK_M);
		menuItem.setActionCommand("CPPalMisc");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Misc", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_stroke"), true);
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.setActionCommand("CPPalStroke");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Stroke", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_swatches"), true);
		menuItem.setMnemonic(KeyEvent.VK_W);
		menuItem.setActionCommand("CPPalSwatches");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Color Swatches", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_textures"), true);
		menuItem.setMnemonic(KeyEvent.VK_X);
		menuItem.setActionCommand("CPPalTextures");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Textures", (JCheckBoxMenuItem) menuItem);

		menuItem = new JCheckBoxMenuItem(language.getString("show_tools"), true);
		menuItem.setMnemonic(KeyEvent.VK_T);
		menuItem.setActionCommand("CPPalTool");
		menuItem.addActionListener(listener);
		submenu.add(menuItem);
		paletteItems.put("Tools", (JCheckBoxMenuItem) menuItem);

		menu.add(submenu);

		//
		// Help Menu
		//

		menu = new JMenu(language.getString("menu_help"));
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);

		menuItem = new JMenuItem(language.getString("about"), KeyEvent.VK_A);
		menuItem.getAccessibleContext().setAccessibleDescription(language.getString("about_hint"));
		menuItem.setActionCommand("CPAbout");
		menuItem.addActionListener(listener);
		menu.add(menuItem);

		return menuBar;
	}

	public void showPalette(String palette, boolean show) {
		paletteManager.showPalette(palette, show);
	}

	public void setPaletteMenuItem(String title, boolean selected) {
		JCheckBoxMenuItem item = paletteItems.get(title);
		if (item != null) {
			item.setSelected(selected);
		}
	}

	public void togglePalettes() {
		paletteManager.togglePalettes();
	}

	class CPDesktop extends JDesktopPane {

		public CPDesktop() {
			addComponentListener(new ComponentAdapter() {

				public void componentResized(ComponentEvent e) {
					bg.setSize(getSize());
					bg.validate();
				}
			});
		}
	}
}
