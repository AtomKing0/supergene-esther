package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class pc0 implements f00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3620b;

    public pc0(Context context, String str, String str2) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f3620b = context.getSharedPreferences("com.appboy.storage.appboy_event_storage" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    @Override // bo.app.f00
    public final void a(e00 event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (this.f3619a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ic0(event), 6, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new jc0(event), 7, (Object) null);
        SharedPreferences.Editor editorEdit = this.f3620b.edit();
        String str = ((ba) event).f2434d;
        event.getClass();
        String string = ((ba) event).forJsonPut().toString();
        kotlin.jvm.internal.t.h(string, "forJsonPut().toString()");
        editorEdit.putString(str, string).apply();
    }

    @Override // bo.app.f00
    public final void a(Set events) {
        kotlin.jvm.internal.t.i(events, "events");
        if (this.f3619a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new nc0(events), 6, (Object) null);
            return;
        }
        SharedPreferences.Editor editorEdit = this.f3620b.edit();
        Iterator it = events.iterator();
        while (it.hasNext()) {
            String str = ((ba) ((e00) it.next())).f2434d;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new oc0(str), 7, (Object) null);
            editorEdit.remove(str);
        }
        editorEdit.apply();
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    @Override // bo.app.f00
    public final Collection a() {
        if (this.f3619a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) kc0.f3241a, 6, (Object) null);
            return kotlin.collections.v.l();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Map<String, ?> all = this.f3620b.getAll();
        kotlin.jvm.internal.t.h(all, "prefs.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String uniqueIdentifier = entry.getKey();
            Object value = entry.getValue();
            kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
            n0Var.f29834a = "";
            try {
                kotlin.jvm.internal.t.g(value, "null cannot be cast to non-null type kotlin.String");
                n0Var.f29834a = (String) value;
                z9 z9Var = ba.f2429g;
                String serializedEvent = (String) value;
                kotlin.jvm.internal.t.h(uniqueIdentifier, "eventId");
                z9Var.getClass();
                kotlin.jvm.internal.t.i(serializedEvent, "serializedEvent");
                kotlin.jvm.internal.t.i(uniqueIdentifier, "uniqueIdentifier");
                e00 e00VarA = z9Var.a(new t8(serializedEvent, uniqueIdentifier));
                if (e00VarA != null) {
                    linkedHashSet.add(e00VarA);
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new lc0(uniqueIdentifier, n0Var), 4, (Object) null);
                SharedPreferences.Editor editorEdit = this.f3620b.edit();
                editorEdit.remove(uniqueIdentifier);
                editorEdit.apply();
            }
        }
        return linkedHashSet;
    }
}
