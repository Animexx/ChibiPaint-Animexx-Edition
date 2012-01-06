package chibipaint.gui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tobias Hößl
 */
public class CPLanguageDE extends CPLanguage {

    private Map<String, String> language = new HashMap<String, String>();
    
    private CPLanguage fallback;
    
    public CPLanguageDE() {
        language.put("menu_edit", "Bearbeiten");
        language.put("menu_file", "Datei");
        language.put("menu_layers", "Ebene");
        language.put("menu_effects", "Effekte");
        language.put("menu_noise", "Rauschen");
        language.put("menu_view", "Ansicht");
        language.put("menu_help", "Hilfe");
        language.put("menu_palettes", "Dialoge");
        language.put("about", "Info über ChibiPaint");
        language.put("about_hint", "Zeigt einige Informationen über ChibiPaint an");
        language.put("send_oekaki", "Oekaki veröffentlichen");
        language.put("send_oekaki_hint", "Lädt das Oekaki auf den Animexx-Server hoch und beendet ChibiPaint anschließend.");
        language.put("undo", "Rückgängig");
        language.put("undo_hinT", "Die letzte Aktion rückgängig machen");
        language.put("redo", "Wiederherstellen");
        language.put("redo_hint", "Wiederholt die zuletzt rückgängig gemachte Aktion");
        language.put("clear_memory", "Historie leeren");
        language.put("clear_memory_hint", "Entfernt alle Informationen über vorige Aktionen, um Arbeitsspeicher freizugeben.");
        language.put("clear_memory_hint2", "Dieser Aufruf löscht alle Daten, um die vorigen Arbeitsschritte rückgängig zu machen. Sicher?");
        language.put("cut", "Ausschneiden");
        language.put("copy", "Kopieren");
        language.put("copy_merged", "Copy Merged [??]");
        language.put("paste", "Einfügen");
        language.put("select_all", "Alles auswählen");
        language.put("select_all_hint", "Die gesamte Zeichenfläche auswählen");
        language.put("deselect", "Nichts auswählen");
        language.put("deselect_hint", "Diesamte Auswahl aufheben");
        language.put("duplicate", "Verdoppeln");
        language.put("duplicate_hint", "Erzeugt eine Kopie der aktuellen Ebene");
        language.put("merge_down", "Nach unten vereinen");
        language.put("merge_down_hint", "Vereint die aktuell ausgewählte Ebene mit der Darunterliegenden");
        language.put("merge_visible", "Alle Ebenen vereinen");
        language.put("merge_visible_hint", "Führt alle sichtbaren Ebenen zusammen");
        language.put("clear", "Löschen");
        language.put("clear_hint", "Löscht den ausgewählten Bildausschnitt");
        language.put("fill", "Füllen");
        language.put("fill_hint", "Füllt den ausgewählten Bildausschnitt mit der aktuellen Farbe");
        language.put("flip_h", "Horizontal spiegeln");
        language.put("flip_h_hint", "Spiegelt den aktuell ausgewählten Bildausschnitt horizontal");
        language.put("flip_v", "Vertikal spiegeln");
        language.put("flip_v_hint", "Spiegelt den aktuell ausgewählten Bildausschnitt vertikal");
        language.put("invert", "Invertieren");
        language.put("invert_h", "Invertiert die Farben");
        language.put("blur", "Weichzeichnen");
        language.put("box_blur", "Feld weichzeichnen");
        language.put("box_blur_hint", "");
        language.put("render_mono", "Schwarzweiß-Rauschen");
        language.put("render_mono_hint", "");
        language.put("render_color", "Farb-Rauschen");
        language.put("render_color_hint", "");
        language.put("floating_mode", "Seperates Fenster");
        language.put("floating_mode_hint", "Öffnet ChibiPaint in einem seperaten Fenster");
        language.put("zoom_in", "Vergrößern");
        language.put("zoom_out", "Verkleinern");
        language.put("zoom_100", "Originalgröße");
        language.put("zoom_100_hint", "Setzt die Ansicht auf 100% zurück");
        language.put("linear_int", "Linear interpolieren");
        language.put("linear_int_hint", "Zeigt das Bilder beim Vergrößern weicher");
        language.put("show_grid", "Raster anzeigen");
        language.put("show_grid_hint", "Zeigt ein Raster über dem Bild an");
        language.put("grid_opt", "Raster konfigurieren...");
        language.put("grid_opt_hint", "Zeigt die Konfiguration des Rasters");
        language.put("toggle_palettes", "Paletten an/aus");
        language.put("toggle_palettes_hint", "Zeigt alle Paletten an oder versteckt sie");
        language.put("show_brush", "Zeige Pinsel");
        language.put("show_tools", "Zeige Werkzeuge");
        language.put("show_textures", "Zeige Texturen");
        language.put("show_swatches", "Zeige Farbauswahl");
        language.put("show_stroke", "Zeige Konturen");
        language.put("show_misc", "Zeige Verschiedenes");
        language.put("show_layers", "Zeige Ebenen");
        language.put("show_color", "Zeige Farbmischpult");
        
        language.put("palette_color", "Farbe");
        language.put("palette_blend", "Blend [???]");
        language.put("palette_brushsize", "Pinselgröße");
        language.put("palette_opacity", "Deckkraft");
        language.put("palette_smoothing", "Kantenglättung");
        language.put("palette_scattering", "Scattering [??]");
        language.put("palette_spacing", "Abstände");
        
        language.put("palette_inverse", "Invertieren");
        language.put("palette_mirror", "Spiegeln");
        language.put("palette_brightness", "Helligkeit");
        language.put("palette_contrast", "Kontrast");
        language.put("palette_reset", "zurücksetzen");
        
        language.put("tool_tip_rect", "Rechteckige Auswahl");
        language.put("tool_tip_move", "Aktuelle Auswahl verschieben");
        language.put("tool_tip_fill", "Die aktuelle Ebene mit der ausgewählten Farbe füllen");
        language.put("tool_tip_rotate", "Die aktuelle Ebene rotieren");
        language.put("tool_tip_pencil", "Stift");
        language.put("tool_tip_pen", "Pinsel");
        language.put("tool_tip_airbrush", "Sprühpistole");
        language.put("tool_tip_watercolor", "Wasserfarbe");
        language.put("tool_tip_eraser", "Radierer");
        language.put("tool_tip_eraser_soft", "Weicher Radierer");
        language.put("tool_tip_smudge", "Verschmieren");
        language.put("tool_tip_blender", "Farbverlauf zeichnen");
        language.put("tool_tip_dodge", "Aufhellen");
        language.put("tool_tip_burn", "Abdunkeln");
        language.put("tool_tip_blur", "Weichzeichnen");
        
        language.put("status_edit_time", "Zeit");
        language.put("status_edit_mem", "Mem");
        language.put("status_edit_zoom", "Zoom");

        language.put("send_size_string", "Hiermit lädst du das Oekaki hoch und beendest dieses Zeichenprogramm.\n\n"
                + "Soll auch die ChibiPaint-Datei mit den Ebenen hochgeladen werden?\n"
                + "Die Datenmenge erhöht sich dadurch um %chi_size% KB \n"
                + "Insgesamt sind es dann: %total_size%  KB\n\n"
                + "Wenn die ChibiPaint-Datei hochgeladen wird, kannst du das Oekaki später mit allen bisher\n"
                + "angelegten Ebenen weiter bearbeiten, ansonsten wird das gesamte Bild auf einer Ebene zusammengeführt.\n\n"
		+ "Wähle 'Ja', um beide Dateien hochzuladen. (empfohlen)\n"
		+ "Wähle 'Nein', um nur das fertige Bild hochzuladen.\n"
		+ "Wähle 'Abbrechen', um nichts hochzuladen und das Bild weiter zu bearbeiten.\n\n");
        language.put("send_string", "Oekaki hochladen");
        
        fallback = new CPLanguageEN();
    }
    
    @Override
    public String[] getBrushTipNames() {
        String[] x = { "Rund, pixelig", "Rund, harte Kante", "Rund, weich", "Quadrat, pixelig", "Quadrat, harte Kante" };
        return x;
    }
    
    @Override
    public String getString(String def) {
        String s = language.get(def);
        if (s == null) return fallback.getString(def);
        else return s;
    }

    @Override
    public String[] getLayerModeNames() {
        String[] x = { "Normal", "Multiply", "Add", "Screen", "Lighten", "Darken", "Subtract", "Dodge", "Burn",
			"Overlay", "Hard Light", "Soft Light", "Vivid Light", "Linear Light", "Pin Light" };
        return x;
    }
    
    
}
