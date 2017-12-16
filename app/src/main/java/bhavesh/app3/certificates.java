package bhavesh.app3;

/**
 * Created by User on 24-Jan-17.
 */

public class certificates {
    private String title;
    private String info;
    private int iconID;

    public certificates(String title, String info,int iconID)
    {
        super();
        this.title=title;
        this.info=info;
        this.iconID=iconID;
    }

    public String getTitle() {
        return title;
    }

    public int getIconID() {
        return iconID;
    }

    public String getInfo() {
        return info;
    }

}
