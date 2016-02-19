package Utils;

/**
 * Created by PY-DEV on 2/17/2016.
 */
public class StoreJson {

    String posterItem;
    String titleItem;
    String posterItemLarge;
    String overView;
    String releaseDate;
    double popularityItem;
    double votesItems;
    double voteItemsAverageItems;

    public StoreJson(){

        posterItem = "None";
        titleItem = "None";
        posterItemLarge = "None";
        overView = "None";
        releaseDate = "None";
        popularityItem = 0.0;
        votesItems = 0.0;
        voteItemsAverageItems = 0.0;

    }

    public StoreJson(String titleItem,
                     String posterItem,
                     String posterItemLarge,
                     String overView,
                     String releaseDate,
                     double popularityItem,
                     double votesItems,
                     double voteItemsAverageItems){

        this.posterItem = posterItem;
        this.posterItemLarge = posterItemLarge;
        this.titleItem = titleItem;
        this.overView = overView;
        this.popularityItem = popularityItem;
        this.releaseDate = releaseDate;
        this.votesItems = votesItems;
        this.voteItemsAverageItems = voteItemsAverageItems;
    }

    public String getPosterItem() {
        return posterItem;
    }

    public void setPosterItem(String posterItem) {
        this.posterItem = posterItem;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public void setTitleItem(String titleItem) {
        this.titleItem = titleItem;
    }

    public String getPosterItemLarge() {
        return posterItemLarge;
    }

    public void setPosterItemLarge(String posterItemLarge) {
        this.posterItemLarge = posterItemLarge;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPopularityItem() {
        return popularityItem;
    }

    public void setPopularityItem(double popularityItem) {
        this.popularityItem = popularityItem;
    }

    public double getVotesItems() {
        return votesItems;
    }

    public void setVotesItems(double votesItems) {
        this.votesItems = votesItems;
    }

    public double getVoteItemsAverageItems() {
        return voteItemsAverageItems;
    }

    public void setVoteItemsAverageItems(double voteItemsAverageItems) {
        this.voteItemsAverageItems = voteItemsAverageItems;
    }
}
