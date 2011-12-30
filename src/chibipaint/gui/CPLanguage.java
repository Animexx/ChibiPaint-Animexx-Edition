package chibipaint.gui;

/**
 *
 * @author Tobias Hößl
 */
public abstract class CPLanguage {
    
    public static CPLanguage getLanguageClass(String str) {
        if (str.equalsIgnoreCase("de")) return new CPLanguageDE();
        else return new CPLanguageEN();
    }
            
    abstract public String[] getBrushTipNames();
    abstract public String[] getLayerModeNames();
    abstract public String getString(String def);
}
