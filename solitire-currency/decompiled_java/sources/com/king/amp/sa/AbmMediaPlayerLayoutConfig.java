package com.king.amp.sa;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmMediaPlayerLayoutConfig {
    private final String TAG;
    private JSONArray chapterConfig;
    private List<Map<String, String>> chapterConfigMapList;
    private JSONObject layoutConfig;
    private Map<String, String> layoutConfigMap;
    private String layoutConfigString;

    public AbmMediaPlayerLayoutConfig() {
        this.TAG = "AbmMediaPlayerLayoutConfig";
        this.layoutConfig = new JSONObject();
    }

    private void generateChapterConfigMapList() {
        for (int i10 = 0; i10 < this.chapterConfig.length(); i10++) {
            try {
                JSONObject jSONObject = this.chapterConfig.getJSONObject(i10);
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
                this.chapterConfigMapList.add(map);
            } catch (JSONException unused) {
                Log.e("AbmMediaPlayerLayoutConfig", "Error when generating chapter config map.");
                return;
            }
        }
    }

    private void generateLayoutConfigMap() {
        Iterator<String> itKeys = this.layoutConfig.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                this.layoutConfigMap.put(next, this.layoutConfig.getString(next));
            } catch (JSONException unused) {
                Log.e("AbmMediaPlayerLayoutConfig", "Error when generating layout config map.");
            }
        }
    }

    public List<Map<String, String>> getChapterConfigMapList() {
        return this.chapterConfigMapList;
    }

    public Map<String, String> getLayoutConfigMap() {
        return this.layoutConfigMap;
    }

    public String getLayoutConfigString() {
        return this.layoutConfigString;
    }

    public void setChapterConfig(String str) {
        try {
            this.chapterConfig = new JSONArray(str);
            this.chapterConfigMapList = new ArrayList();
            generateChapterConfigMapList();
        } catch (JSONException unused) {
            Log.e("AbmMediaPlayerLayoutConfig", "Error when parsing Json string.");
        }
    }

    public AbmMediaPlayerLayoutConfig(@Nullable String str) {
        this.TAG = "AbmMediaPlayerLayoutConfig";
        try {
            this.layoutConfigString = str;
            this.layoutConfig = new JSONObject(TextUtils.isEmpty(str) ? JsonUtils.EMPTY_JSON : str);
            this.layoutConfigMap = new HashMap();
            this.chapterConfigMapList = new ArrayList();
            generateLayoutConfigMap();
        } catch (JSONException unused) {
            Log.e("AbmMediaPlayerLayoutConfig", "Error when parsing Json string.");
        }
    }
}
