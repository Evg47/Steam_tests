package Models;

import java.util.Objects;

public class SearchCommunityMarketModel {
    private String gameId;
    private String heroValue;
    private String rarityId;
    private String SearchText;

    public SearchCommunityMarketModel(String gameId, String heroValue, String rarityId, String searchText) {
        this.gameId = gameId;
        this.heroValue = heroValue;
        this.rarityId = rarityId;
        SearchText = searchText;
    }

    public String getGameId() {
        return gameId;
    }

    public String getHeroValue() {
        return heroValue;
    }

    public String getRarityId() {
        return rarityId;
    }

    public String getSearchText() {
        return SearchText;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setHeroValue(String heroValue) {
        this.heroValue = heroValue;
    }

    public void setRarityId(String rarityId) {
        this.rarityId = rarityId;
    }

    public void setSearchText(String searchText) {
        SearchText = searchText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCommunityMarketModel that = (SearchCommunityMarketModel) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(heroValue, that.heroValue) && Objects.equals(rarityId, that.rarityId) && Objects.equals(SearchText, that.SearchText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, heroValue, rarityId, SearchText);
    }
}
