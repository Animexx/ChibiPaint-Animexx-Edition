package chibipaint.gui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tobias Hößl
 */
public class CPLanguageEN extends CPLanguage {

    private Map<String, String> language = new HashMap<String, String>();
    
    public String[] brush_tipnames = { "Round Pixelated", "Round Hard Edge", "Round Soft", "Square Pixelated", "Square Hard Edge" };
    
    public CPLanguageEN() {
        language.put("menu_edit", "Edit");
        language.put("menu_file", "File");
        language.put("menu_layers", "Layers");
        language.put("menu_effects", "Effects");
        language.put("menu_noise", "Noise");
        language.put("menu_view", "View");
        language.put("menu_help", "Help");
        language.put("menu_palettes", "Palettes");
        language.put("about", "About...");
        language.put("about_hint", "Displays some information about ChibiPaint");
        language.put("send_oekaki", "Send Oekaki");
        language.put("send_oekaki_hint", "Sends the oekaki to the server and exits ChibiPaint");
        language.put("undo", "Undo");
        language.put("undo_hinT", "Undoes the most recent action");
        language.put("redo", "Redo");
        language.put("redo_hint", "Redoes a previously undone action");
        language.put("clear_memory", "Clear History");
        language.put("clear_memory_hint", "Removes all undo/redo information to regain memory");
        language.put("clear_memory_hint2", "You're about to clear the current Undo/Redo history.\nThis operation cannot be undone, are you sure you want to do that?");
        language.put("cut", "Cut");
        language.put("copy", "Copy");
        language.put("copy_merged", "Copy Merged");
        language.put("paste", "Paste");
        language.put("select_all", "Select All");
        language.put("select_all_hint", "Selects the whole canvas");
        language.put("deselect", "Deselect");
        language.put("deselect_hint", "Deselects the whole canvas");
        language.put("duplicate", "Duplicate");
        language.put("duplicate_hint", "Creates a copy of the currently selected layer");
        language.put("merge_down", "Merge Down");
        language.put("merge_down_hint", "Merges the currently selected layer with the one directly below it");
        language.put("merge_visible", "Merge All Layers");
        language.put("merge_visible_hint", "Merges all the layers");
        language.put("clear", "Clear");
        language.put("clear_hint", "Clears the selected area");
        language.put("fill", "Fill");
        language.put("fill_hint", "Fills the selected area with the current color");
        language.put("flip_h", "Flip Horizontal");
        language.put("flip_h_hint", "Flips the current selected area horizontally");
        language.put("flip_v", "Flip Vertical");
        language.put("flip_v_hint", "Flips the current selected area vertically");
        language.put("invert", "Invert");
        language.put("invert_h", "Invert the image colors");
        language.put("blur", "Blur");
        language.put("box_blur", "Box Blur...");
        language.put("box_blur_hint", "Blur effect");
        language.put("render_mono", "Render Monochromatic");
        language.put("render_mono_hint", "Fills the selection with noise");
        language.put("render_color", "Render Color");
        language.put("render_color_hint", "Fills the selection with colored noise");
        language.put("floating_mode", "Floating mode");
        language.put("floating_mode_hint", "Opens ChibiPaint in an independent window");
        language.put("zoom_in", "Zoom In");
        language.put("zoom_out", "Zoom Out");
        language.put("zoom_100", "Zoom 100%");
        language.put("zoom_100_hint", "Resets the zoom factor to 100%");
        language.put("linear_int", "Use Linear Interpolation");
        language.put("linear_int_hint", "Linear interpolation is used to give a smoothed looked to the picture when zoomed in");
        language.put("show_grid", "Show Grid");
        language.put("show_grid_hint", "Displays a grid over the image");
        language.put("grid_opt", "Grid options...");
        language.put("grid_opt_hint", "Shows the grid options dialog box");
        language.put("toggle_palettes", "Toggle Palettes");
        language.put("toggle_palettes_hint", "Hides or shows all palettes");
        language.put("show_brush", "Show Brush");
        language.put("show_tools", "Show Tools");
        language.put("show_textures", "Show Textures");
        language.put("show_swatches", "Show Swatches");
        language.put("show_stroke", "Show Stroke");
        language.put("show_misc", "Show Misc");
        language.put("show_layers", "Show Layers");
        language.put("show_color", "Show Color");
        
        language.put("palette_color", "Color");
        language.put("palette_blend", "Blend");
        language.put("palette_brushsize", "Brush Size");
        language.put("palette_opacity", "Opacity");
        language.put("palette_smoothing", "Smoothing");
        language.put("palette_scattering", "Scattering");
        language.put("palette_spacing", "Spacing");
        
        language.put("palette_inverse", "Inverse");
        language.put("palette_mirror", "Mirror");
        language.put("palette_brightness", "Brightness");
        language.put("palette_contrast", "Contrast");
        language.put("palette_reset", "reset");
        
        language.put("tool_tip_rect", "Select rectangular area");
        language.put("tool_tip_move", "Move selected area");
        language.put("tool_tip_fill", "Fill the current layer with the selected color");
        language.put("tool_tip_rotate", "Rotate the current layer");
        language.put("tool_tip_pencil", "Pencil");
        language.put("tool_tip_pen", "Pen");
        language.put("tool_tip_airbrush", "Air Brush");
        language.put("tool_tip_watercolor", "Water Color");
        language.put("tool_tip_eraser", "Eraser");
        language.put("tool_tip_eraser_soft", "Eraser soft");
        language.put("tool_tip_smudge", "Smudge");
        language.put("tool_tip_blender", "Blender");
        language.put("tool_tip_dodge", "Dodge");
        language.put("tool_tip_burn", "Burn");
        language.put("tool_tip_blur", "Blur");
        
        language.put("status_edit_time", "Time");
        language.put("status_edit_mem", "Mem");
        language.put("status_edit_zoom", "Zoom");
        
        
        language.put("send_size_string", "You're about to send your oekaki to the server and end your ChibiPaint session.\n\nWould you like to send the layers file as well?\n"
                + "Additional upload size: %chi_size% KB \n"
                + "Total upload size: %total_size%  KB\n\nThe layers file allows you to edit your oekaki later with all its layers intact\n\n"
		+ "Choose 'Yes' to send both files. (recommended)\n"
		+ "Choose 'No' to send the finished picture only.\n"
		+ "Choose 'Cancel' if you wish to continue editing your picture without sending it.\n\n");
        language.put("send_string", "Send Oekaki");
    }
    
    public String[] getBrushTipNames() {
        String[] x = { "Round Pixelated", "Round Hard Edge", "Round Soft", "Square Pixelated", "Square Hard Edge" };
        return x;
    }
    
    public String[] getLayerModeNames() {
        String[] x = { "Normal", "Multiply", "Add", "Screen", "Lighten", "Darken", "Subtract", "Dodge", "Burn",
			"Overlay", "Hard Light", "Soft Light", "Vivid Light", "Linear Light", "Pin Light" };
        return x;
    }
    
    
    public String getString(String def) {
        String s = language.get(def);
        if (s == null) return "@" + def + "@";
        else return s;
    }
    
}
