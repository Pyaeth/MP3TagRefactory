package resources;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amicu
 */
public class SavedVariables {

    private static boolean isTitleSelected;
    private static boolean isContributingArtistsSelected;
    private static boolean isAlbumArtistsSelected;
    private static boolean isAlbumSelected;
    private static boolean isYearSelected;
    private static boolean isTrackNoSelected;
    private static boolean isGenreSelected;
    
    public static Map<String,Boolean> getSavedVariables() {
        Map<String,Boolean> options = new HashMap<>();
        options.put("refactorTitle", isTitleSelected);
        options.put("refactorAlbumArtist", isAlbumArtistsSelected);
        options.put("refactorAlbum", isAlbumSelected);
        options.put("refactorYear", isYearSelected);
        options.put("refactorTrackNo", isTrackNoSelected);
        options.put("refactorGenre", isGenreSelected);
        options.put("refactorContributingArtists", isContributingArtistsSelected);
        return options;
    }

    public static void setIsTitleSelected(boolean isTitleSelected) {
        SavedVariables.isTitleSelected = isTitleSelected;
    }

    public static void setIsContributingArtistsSelected(boolean isContributingArtistsSelected) {
        SavedVariables.isContributingArtistsSelected = isContributingArtistsSelected;
    }

    public static void setIsAlbumArtistsSelected(boolean isAlbumArtistsSelected) {
        SavedVariables.isAlbumArtistsSelected = isAlbumArtistsSelected;
    }

    public static void setIsAlbumSelected(boolean isAlbumSelected) {
        SavedVariables.isAlbumSelected = isAlbumSelected;
    }

    public static void setIsYearSelected(boolean isYearSelected) {
        SavedVariables.isYearSelected = isYearSelected;
    }

    public static void setIsTrackNoSelected(boolean isTrackNoSelected) {
        SavedVariables.isTrackNoSelected = isTrackNoSelected;
    }

    public static void setIsGenreSelected(boolean isGenreSelected) {
        SavedVariables.isGenreSelected = isGenreSelected;
    }
    
}
