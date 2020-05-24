package com.example.myapplication4;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class DiliOneModel {

    public String title;
    public String content;
    public String url;
    public String addtime;
}

class TestModel {

    /**
     * counttotal : 13
     * picture : [{"id":"20502","albumid":"2173","title":"鍥藉鍦扮悊瀛︿細","content":"鍥藉鍦扮悊瀛︿細鏄笘鐣屼笂鏈�澶х殑闈炶惀鍒╃瀛︿笌鏁欒偛缁勭粐涔嬩竴锛屾垚绔嬩簬1888骞达紝浠ャ�屽杩涗笌鏅強鍦扮悊鐭ヨ瘑銆嶄负瀹楁棬锛岃嚧鍔涗簬婵�鍙戝ぇ浼楀叧鐖卞湴鐞冦�傚皢杩�130骞存潵锛屽浼氬湪涓栫晫鍚勪釜瑙掕惤璧炲姪浜嗚秴杩�1涓囦袱鍗冧欢浠ヤ笂鐨勭爺绌躲�佹帰绱笌淇濊偛璁\u2033垝鈥斺�旂綏浼峰反鎷夊痉锛圧obert Ballard锛夌殑閾佽揪灏煎彿娌夎埞瀵昏幏锛涚弽路鍙ゅ痉锛圝ane Goodall锛夌殑榛戠尒鐚╄涓虹爺绌讹紱鐞嗗療路浜氬綋鏂紙Richard Adams锛夊椹泤閮ㄨ惤鐨勮�冨彜瀛︾爺绌垛�︹�︺�屽浗瀹跺湴鐞嗗浼氥�嶅皢鑰冨彜銆佸姩妞嶇墿銆佺敓鍛界瀛﹀強涓栫晫姣忎竴涓钀界殑鍙樺寲锛屼互鏉傚織銆佸浘涔︺�佸湴鍥俱�佺數瑙嗗強鍚勭濯掍綋椴滄椿鍛堢幇缁欎笘浜恒�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271762.jpg","size":"146837","addtime":"2018-11-15 16:49:24","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271762.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"140ec65cf6f953ebaeceb3da75434291","sort":"20502"},{"id":"20501","albumid":"2173","title":"缇庡浗銆婂浗瀹跺湴鐞嗐�嬫潅蹇�","content":"銆婂浗瀹跺湴鐞嗐�嬫潅蹇楁槸銆屽浗瀹跺湴鐞嗗浼氥�嶆墍鍙戣鐨勫浼氫細鍒婏紝浠ヨ嫳鏂囧強鍏朵粬40绉嶈瑷�鍙戣锛屾瘡鏈堟湁6000涓囪鑰呴槄璇汇�傝嚜鍒涘垔浠ユ潵涓�鐩翠互绮鹃噰缁濅鸡鐨勬憚褰憋紝涓ヨ皑鐪熷疄鐨勬枃瀛楋紝绮惧瘑鍑嗙\u2018鐨勫湴鍥句笌鐢熷姩鐨勬彃鐢伙紝灏嗗浗瀹跺湴鐞嗗浼氱殑绗竴鎵嬪彂鐜帮紝閫佸埌鍏ㄧ悆璇昏�呮墜涓�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271749.jpg","size":"181447","addtime":"2018-11-15 16:49:12","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271749.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"aa8a1e3b3f94073db06f4430de3cd743","sort":"20501"},{"id":"20500","albumid":"2173","title":"缇庡浗銆婂浗瀹跺湴鐞嗐�嬫潅蹇楋紙绻佷綋涓枃鐗堬級","content":"銆婂浗瀹跺湴鐞嗐�嬫潅蹇椾腑鏂囩増锛屽湪鍙版咕鍑虹増锛屽唴瀹圭粷澶ч儴鍒嗕负缇庡浗銆婂浗瀹跺湴鐞嗐�嬫潅蹇楃殑鍘熺増鍐呭锛岀敱鏈夊骞寸粡楠岀殑璇戣�呭拰缂栬緫鍒朵綔鎴愭柟渚块槄璇荤殑涓枃绻佷綋鐗堬紝鏃㈠繝浜庡師鐗堬紝鍙堜究浜庨槄璇伙紝涓�鐫逛笘鐣屼竴娴佹憚褰卞笀鐨勭簿褰╁ぇ浣滐紝鏇磋兘鎺屾彙鍥介檯鏈�鏂扮鎶�銆佺幆淇濈瓑鐮旂┒鎴愭灉锛岀珯鍦ㄧ涓�绾垮叧蹇冨湴鐞冭嚜鐒躲�佹皯鐢熴�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271738.jpg","size":"157650","addtime":"2018-11-15 16:49:00","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271738.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"a02723695ae6a5b041cdd5f06bff953b","sort":"20500"},{"id":"20499","albumid":"2173","title":"鏈熷緟鎮ㄥ姞鍏ヨ繖涓壒鍒殑鍏ㄧ悆鎬у洟浣�","content":"鎮ㄨ闃呮潅蹇楃殑涓�閮ㄥ垎娆鹃」锛屽皢鐢ㄤ簬瀹為檯璧炲姪鍏ㄧ悆鍚勫湴鎵�杩涜鐨勬帰绱㈣鍒掋�傛垜浠浉淇℃偍鐨勫姞鍏ワ紝灏嗘湁鍔╀簬涓栦汉鎺㈢储鍦扮悆銆佷簡瑙ｅ畤瀹欍�佹帰娴嬫繁娴峰強鎵惧鏀瑰杽鍦扮悆鐜扮姸鐨勬柊鏂规硶锛岃�屾偍涔熷皢鍥犱负鍔犲叆杩欎釜鐗瑰埆鐨勫叏鐞冩�у洟浣撹�岃幏寰楄澶氫箰瓒ｃ�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271726.jpg","size":"158258","addtime":"2018-11-15 16:48:49","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271726.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"88c99c64c4aa9dcb27a3737833b38a5b","sort":"20499"},{"id":"20498","albumid":"2173","title":"寰�鏈熷弬鑰冿細2018骞�5鏈堝垔","content":"鏈笓棰樺唴灞曠ず鐨勬墍鏈夋潅蹇楀皝闈㈠潎涓哄線鏈熷唴瀹癸紝浠呬緵鍙傝�冦�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271710.jpg","size":"210449","addtime":"2018-11-15 16:48:33","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271710.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"96607cf379002f95a1bf72a3f960954c","sort":"20498"},{"id":"20497","albumid":"2173","title":"寰�鏈熷弬鑰冿細2018骞�6鏈堝垔","content":"瑕佸鏂欒繕鏄鍦扮悆锛熺偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271694.jpg","size":"80440","addtime":"2018-11-15 16:48:16","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271694.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"e9c835b6df832d052cc094dff3b256a1","sort":"20497"},{"id":"20496","albumid":"2173","title":"寰�鏈熷弬鑰冿細2018骞�7鏈堝垔","content":"鐞ョ弨钘忛緳銆傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271677.jpg","size":"91155","addtime":"2018-11-15 16:47:58","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271677.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"514cb2c92c841387d00561a7657cc2df","sort":"20496"},{"id":"20495","albumid":"2173","title":"姣忔湀涓�娆℃湡寰�","content":"鐐瑰嚮鍥剧墖鎴栭摼鎺ヨ闃咃細 https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271659.jpg","size":"125829","addtime":"2018-11-15 16:47:41","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271659.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"493664ab4ae40f741b2840d60e251d69","sort":"20495"},{"id":"20494","albumid":"2173","title":"姣忔湀涓�浠芥弧瓒�","content":"鏀惰揣鍦板潃鍙戠敓鍙樻洿鏃讹紝鍙互鑱旂郴瀹㈡湇鍙樻洿鍦板潃銆傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1572406022.jpg","size":"225894","addtime":"2018-11-15 16:47:02","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1572406022.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"f600c6675107bcd8076c63b56ea47d71","sort":"20494"},{"id":"20493","albumid":"2173","title":"鍏ㄥ勾鏉傚織12鏈�","content":"鏉傚織鍏�12鏈燂紝姣忔湀涓�鏈燂紝鍒�12涓湀瀵勫嚭銆傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542271595.jpg","size":"145817","addtime":"2018-11-15 16:46:39","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542271595.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"b3bcde61ec66841281a852e7bab5d5cc","sort":"400"},{"id":"20505","albumid":"2173","title":"姣忔湀鍖呴偖","content":"鏉傚織姣忔湀鏈堝垵鍑虹増锛屽姙鐞嗚繘鍙ｆ墜缁悗蹇�掍笌鎮紝澶ф姣忔湀20鏃ュ瘎鍑恒�備繚璇佹鐗堬紝甯屾湜鎮ㄦ敮鎸侊紒鍏ㄥ浗澶ч儴鍒嗗湴鍖哄揩閫掑寘閭紝鍋忚繙鍦板尯闄ゅ銆傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1542341740.jpg","size":"181121","addtime":"2018-11-16 12:15:42","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1542341740.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"e486a3007828b0b3461132e200823f66","sort":"300"},{"id":"20504","albumid":"2173","title":"璧犲搧","content":"璁㈤槄缇庡浗銆婂浗瀹跺湴鐞嗐�嬫潅蹇楃箒浣撲腑鏂囩増锛�2020鍏ㄥ勾12鏈燂級锛岃禒閫� 鍥藉鍦扮悊鎶撶粧琛竴浠讹紝缁熶竴灏虹爜銆傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1572404754.png","size":"313473","addtime":"2018-11-16 11:55:53","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1572404754.png","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"a80febbaecb2d439a7df565f2f8ad12f","sort":"200"},{"id":"23673","albumid":"2173","title":"浜嗚В璇︽儏","content":"鐐瑰嚮鍥剧墖鎴栭摼鎺ヨ闃咃細https://koudai.com/item.html?itemID=3015917518","url":"http://pic01.bdatu.com/Upload/picimg/1572421565.jpg","size":"173336","addtime":"2019-10-30 15:45:03","author":"","thumb":"http://pic01.bdatu.com/Upload/picimg/1572421565.jpg","encoded":"1","weburl":"http://","type":"pic","yourshotlink":"","copyright":"https://koudai.com/item.html?itemID=3015917518","pmd5":"efd82321095f10c10c5401d9da2d77cd","sort":"1"}]
     */

    private String counttotal;
    private List<PictureBean> picture;

    public String getCounttotal() {
        return counttotal;
    }

    public void setCounttotal(String counttotal) {
        this.counttotal = counttotal;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public static class PictureBean {
        /**
         * id : 20502
         * albumid : 2173
         * title : 鍥藉鍦扮悊瀛︿細
         * content : 鍥藉鍦扮悊瀛︿細鏄笘鐣屼笂鏈�澶х殑闈炶惀鍒╃瀛︿笌鏁欒偛缁勭粐涔嬩竴锛屾垚绔嬩簬1888骞达紝浠ャ�屽杩涗笌鏅強鍦扮悊鐭ヨ瘑銆嶄负瀹楁棬锛岃嚧鍔涗簬婵�鍙戝ぇ浼楀叧鐖卞湴鐞冦�傚皢杩�130骞存潵锛屽浼氬湪涓栫晫鍚勪釜瑙掕惤璧炲姪浜嗚秴杩�1涓囦袱鍗冧欢浠ヤ笂鐨勭爺绌躲�佹帰绱笌淇濊偛璁″垝鈥斺�旂綏浼峰反鎷夊痉锛圧obert Ballard锛夌殑閾佽揪灏煎彿娌夎埞瀵昏幏锛涚弽路鍙ゅ痉锛圝ane Goodall锛夌殑榛戠尒鐚╄涓虹爺绌讹紱鐞嗗療路浜氬綋鏂紙Richard Adams锛夊椹泤閮ㄨ惤鐨勮�冨彜瀛︾爺绌垛�︹�︺�屽浗瀹跺湴鐞嗗浼氥�嶅皢鑰冨彜銆佸姩妞嶇墿銆佺敓鍛界瀛﹀強涓栫晫姣忎竴涓钀界殑鍙樺寲锛屼互鏉傚織銆佸浘涔︺�佸湴鍥俱�佺數瑙嗗強鍚勭濯掍綋椴滄椿鍛堢幇缁欎笘浜恒�傜偣鍑诲浘鐗囨垨閾炬帴璁㈤槄锛� https://koudai.com/item.html?itemID=3015917518
         * url : http://pic01.bdatu.com/Upload/picimg/1542271762.jpg
         * size : 146837
         * addtime : 2018-11-15 16:49:24
         * author :
         * thumb : http://pic01.bdatu.com/Upload/picimg/1542271762.jpg
         * encoded : 1
         * weburl : http://
         * type : pic
         * yourshotlink :
         * copyright : https://koudai.com/item.html?itemID=3015917518
         * pmd5 : 140ec65cf6f953ebaeceb3da75434291
         * sort : 20502
         */

        private String id;
        private String albumid;
        private String title;
        private String content;
        private String url;
        private String size;
        private String addtime;
        private String author;
        private String thumb;
        private String encoded;
        private String weburl;
        private String type;
        private String yourshotlink;
        private String copyright;
        private String pmd5;
        private String sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAlbumid() {
            return albumid;
        }

        public void setAlbumid(String albumid) {
            this.albumid = albumid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getEncoded() {
            return encoded;
        }

        public void setEncoded(String encoded) {
            this.encoded = encoded;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYourshotlink() {
            return yourshotlink;
        }

        public void setYourshotlink(String yourshotlink) {
            this.yourshotlink = yourshotlink;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getPmd5() {
            return pmd5;
        }

        public void setPmd5(String pmd5) {
            this.pmd5 = pmd5;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }
}

public class TestFragment extends Fragment {

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {

            return true;
        }
    });
    private String requestUrl;
    private ArrayList<DiliOneModel> models = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<TestModel.PictureBean> pics;

    public TestFragment(String requestUrl) {

        this.requestUrl = requestUrl;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_fragment,container,false);

        ConstraintLayout constraintLayout = view.findViewById(R.id.test_fragment);

        recyclerView = new RecyclerView(view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setId(R.id.recycle1);
        recyclerView.setBackgroundColor(Color.BLUE);
        ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);
        para.topToTop = R.id.test_fragment;
        para.leftToLeft = R.id.test_fragment;
        para.rightToRight = R.id.test_fragment;
        para.bottomToBottom = R.id.test_fragment;
        para.topMargin = 20;
        para.leftMargin = 20;
        para.rightMargin = 20;
        para.bottomMargin = 20;

        constraintLayout.addView(recyclerView,para);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new RecyclerView.Adapter() {

            class AHolder extends RecyclerView.ViewHolder {

                LinearLayout view;
                public AHolder(@NonNull LinearLayout view) {
                    super(view);

                    this.view = view;
                }
            }
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                LinearLayout linearLayout = new LinearLayout(parent.getContext());
                linearLayout.setId(R.id.line1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

                ImageView imageView = new ImageView(parent.getContext());
                imageView.setId(R.id.img1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.width = 200;
                layoutParams.height = 300;
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);

                TextView textView = new TextView(parent.getContext());
                textView.setId(R.id.title1);
                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(textView);

                return new AHolder(linearLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                AHolder aHolder = (AHolder)holder;
//                DiliOneModel model = models.get(position);
                TestModel.PictureBean model = pics.get(position);

                LinearLayout linearLayout = aHolder.view;
                ImageView imageView = linearLayout.findViewById(R.id.img1);

                ImageLoader imageLoader = ImageLoader.getInstance();
                ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getContext()).build();
                imageLoader.init(imageLoaderConfiguration);
                imageLoader.displayImage(model.getUrl(),imageView);

                TextView textView = linearLayout.findViewById(R.id.title1);
                textView.setText(model.getContent());
            }

            @Override
            public int getItemCount() {
//                return models.size();
                if (pics == null) return 0;

                return pics.size();
            }
        };

        RecyclerView recyclerView = getView().findViewById(R.id.recycle1);
        recyclerView.setAdapter(adapter);

        requestInfos();
    }

    private void requestInfos () {

        new Thread(new Runnable() {
            @Override
            public void run() {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(requestUrl).build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(),"请求失败",Toast.LENGTH_SHORT);
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        //                            JSONObject jsonObject = new JSONObject(response.body().string());
////                            JSONArray jsonArray = jsonObject.getJSONArray("picture");
////                            if (models == null) {
////                                models = new ArrayList<>();
////                            } else  {
////
////                                models.clear();
////                            }
////                            for (int i = 0;i < jsonArray.length();i++){
////
////                                JSONObject object = (JSONObject) jsonArray.get(i);
////                                DiliOneModel model = new DiliOneModel();
////                                model.title = object.getString("title");
////                                model.content = object.getString("content");
////                                model.addtime = object.getString("addtime");
////                                model.url = object.getString("url");
////                                models.add(model);
////                            }
                        Gson gson = new Gson();
                        TestModel testModel = gson.fromJson(response.body().string(),TestModel.class);

                        pics = testModel.getPicture();

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });

                    }
                });

            }
        }).start();
    }
}
