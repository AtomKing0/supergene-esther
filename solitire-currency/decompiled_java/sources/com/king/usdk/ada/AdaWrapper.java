package com.king.usdk.ada;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import hb.c;
import java.util.HashMap;
import support.ada.embed.widget.AdaEmbedView;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AdaWrapper {
    Activity activity;
    String handle;
    HashMap<String, String> metadataMap = new HashMap<>();

    public AdaWrapper(Activity activity, String str) {
        this.handle = str;
        this.activity = activity;
    }

    private c buildMetafields() {
        c cVar = new c();
        Bundle bundle = new Bundle();
        buildMetafieldsBundle(bundle);
        for (String str : bundle.keySet()) {
            cVar = cVar.b(str, (String) bundle.get(str));
        }
        return cVar;
    }

    private void buildMetafieldsBundle(Bundle bundle) {
        for (String str : this.metadataMap.keySet()) {
            bundle.putString(str, this.metadataMap.get(str));
        }
    }

    public void hashMapPut(String str, String str2) {
        this.metadataMap.put(str, str2);
    }

    public void instantiate() {
        Context context = this.activity.findViewById(R.id.content).getContext();
        Intent intent = new Intent(context, (Class<?>) AdaActivity.class);
        intent.putExtra("EXTRA_SETTINGS", new AdaEmbedView.e.a(this.handle).b(buildMetafields()).a());
        context.startActivity(intent);
    }
}
