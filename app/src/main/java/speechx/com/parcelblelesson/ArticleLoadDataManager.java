package speechx.com.parcelblelesson;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leashen on 2017/8/20.
 */

public class ArticleLoadDataManager {
    volatile static private ArticleLoadDataManager manager = null;

    private HashMap<String, Article> articleList;
    private List<String> titleList;

    public ArticleLoadDataManager(){
        articleList = new HashMap<>();
        titleList = new ArrayList<>();
        getData();

    }

    private void getData(){
        String title = "Rain";
        List<ArticleLine> content = new ArrayList<>();
        ArticleLine line = new ArticleLine("Rain is falling all around");
        line.setStdAudioPath("rain/line_1.mp3");
        content.add(line);
        line = new ArticleLine("It falls on field and tree");
        line.setStdAudioPath("rain/line_2.mp3");
        content.add(line);
        line = new ArticleLine("It rains on the umbrella here");
        line.setStdAudioPath("rain/line_3.mp3");
        content.add(line);
        line = new ArticleLine("And on the ships at sea");
        line.setStdAudioPath("rain/line_4.mp3");
        content.add(line);

        articleList.put(title,new Article(title,content));
        titleList.add(title);

        title = "The Wind";
        content = new ArrayList<>();
        line = new ArticleLine("Who has seen the wind?");
        content.add(line);
        line = new ArticleLine("Neither I nor you;");
        content.add(line);
        line = new ArticleLine("But when the leaves hang trembling,");
        content.add(line);
        line = new ArticleLine("The wind is passing through.");
        content.add(line);
        line = new ArticleLine("Who has seen the wind?");
        content.add(line);
        line = new ArticleLine("Neither you nor I;");
        content.add(line);
        line = new ArticleLine("But when the trees bow down their heads,");
        content.add(line);
        line = new ArticleLine("The wind is passing by.");
        content.add(line);

        articleList.put(title,new Article(title,content));
        titleList.add(title);



        title = "What Does The Bee Do";
        content = new ArrayList<>();

        line = new ArticleLine("What does the bee do?");
        content.add(line);
        line = new ArticleLine("Bring home honey.");
        content.add(line);
        line = new ArticleLine("And what does Father do?");
        content.add(line);
        line = new ArticleLine("Bring home money.");
        content.add(line);
        line = new ArticleLine("And what does Mother do?");
        content.add(line);
        line = new ArticleLine("Lay out the money.");
        content.add(line);
        line = new ArticleLine("And what does baby do?");
        content.add(line);
        line = new ArticleLine("Eat up the honey.");
        content.add(line);



        articleList.put(title,new Article(title,content));
        titleList.add(title);

        title = "At The Seaside";
        content = new ArrayList<>();
        line = new ArticleLine("When I was down beside the sea");
        content.add(line);
        line = new ArticleLine("A wooden spade they gave to me");
        content.add(line);
        line = new ArticleLine("To dig the sandy shore");
        content.add(line);
        line = new ArticleLine("The holes were empty like a cup");
        content.add(line);
        line = new ArticleLine("In every hole the sea camp up");
        content.add(line);
        line = new ArticleLine("Till it could come no more");
        content.add(line);



        articleList.put(title,new Article(title,content));
        titleList.add(title);

        title = "A House Of Cards";
        content = new ArrayList<>();

        line = new ArticleLine("A house of cards");
        content.add(line);
        line = new ArticleLine("Is neat and small");
        content.add(line);
        line = new ArticleLine("Shake the table");
        content.add(line);
        line = new ArticleLine("It must fall");
        content.add(line);
        line = new ArticleLine("Find the court cards");
        content.add(line);
        line = new ArticleLine("One by one");
        content.add(line);
        line = new ArticleLine("Raise it, roof it");
        content.add(line);
        line = new ArticleLine("Now it's done");
        content.add(line);
        line = new ArticleLine("Shake the table");
        content.add(line);
        line = new ArticleLine("That's the fun");
        content.add(line);

        articleList.put(title,new Article(title,content));
        titleList.add(title);

        title = "The Star";
        content = new ArrayList<>();
        line = new ArticleLine("Twinkle, twinkle, little star");
        content.add(line);
        line = new ArticleLine("How I wonder what you are");
        content.add(line);
        line = new ArticleLine("Up above the world so high");
        content.add(line);
        line = new ArticleLine("Like a diamond in the sky.");
        content.add(line);
        line = new ArticleLine("When the blazing sun is gone");
        content.add(line);
        line = new ArticleLine("When he nothing shines upon");
        content.add(line);
        line = new ArticleLine("Then you show your little light");
        content.add(line);
        line = new ArticleLine("Twinkle, twinkle all the night.");
        content.add(line);
        line = new ArticleLine("The dark blue sky you keep");
        content.add(line);
        line = new ArticleLine("And often through my curtains peep");
        content.add(line);
        line = new ArticleLine("For you never shut your eye");
        content.add(line);
        line = new ArticleLine("Till the sun is in the sky.");
        content.add(line);
        line = new ArticleLine("It is your bright and tiny spark");
        content.add(line);
        line = new ArticleLine("Lights the traveler in the dark");
        content.add(line);
        line = new ArticleLine("Though I know not what you are");
        content.add(line);
        line = new ArticleLine("Twinkle, twinkle, little star.");
        content.add(line);

        articleList.put(title,new Article(title,content));
        titleList.add(title);
    }

    public static ArticleLoadDataManager getManager(){
        if(manager == null){
            synchronized (ArticleLoadDataManager.class){
                if(manager == null){
                    Log.w("leashen","ArticleLoadDataManager 新创建");
                    manager = new ArticleLoadDataManager();
                }
            }
        }

        return manager;
    }


    public HashMap<String, Article> getArticleList(){
        return this.articleList;
    }

    public List<String> getTitleList(){
        return this.titleList;
    }

    public void release(){
        manager = null;
    }



}
