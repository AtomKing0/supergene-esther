package com.iab.omid.library.activision.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.activision.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f10552b = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f10553a = new ArrayList();

    private e b(View view) {
        for (e eVar : this.f10553a) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    public List<e> a() {
        return this.f10553a;
    }

    public void c(View view) {
        a(view);
        e eVarB = b(view);
        if (eVarB != null) {
            this.f10553a.remove(eVarB);
        }
    }

    private void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    public void b() {
        this.f10553a.clear();
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        a(view);
        a(str);
        if (b(view) == null) {
            this.f10553a.add(new e(view, friendlyObstructionPurpose, str));
        }
    }

    private void a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f10552b.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }
}
