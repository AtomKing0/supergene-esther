package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FragmentTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransition {

    @NotNull
    public static final FragmentTransition INSTANCE;

    @Nullable
    public static final FragmentTransitionImpl PLATFORM_IMPL;

    @Nullable
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    static {
        FragmentTransition fragmentTransition = new FragmentTransition();
        INSTANCE = fragmentTransition;
        PLATFORM_IMPL = new FragmentTransitionCompat21();
        SUPPORT_IMPL = fragmentTransition.resolveSupportImpl();
    }

    private FragmentTransition() {
    }

    public static final void callSharedElementStartEnd(@NotNull Fragment inFragment, @NotNull Fragment outFragment, boolean z10, @NotNull ArrayMap<String, View> sharedElements, boolean z11) {
        kotlin.jvm.internal.t.i(inFragment, "inFragment");
        kotlin.jvm.internal.t.i(outFragment, "outFragment");
        kotlin.jvm.internal.t.i(sharedElements, "sharedElements");
        SharedElementCallback enterTransitionCallback = z10 ? outFragment.getEnterTransitionCallback() : inFragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it = sharedElements.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            ArrayList arrayList2 = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it2 = sharedElements.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getKey());
            }
            if (z11) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    @Nullable
    public static final String findKeyForValue(@NotNull ArrayMap<String, String> arrayMap, @NotNull String value) {
        kotlin.jvm.internal.t.i(arrayMap, "<this>");
        kotlin.jvm.internal.t.i(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : arrayMap.entrySet()) {
            if (kotlin.jvm.internal.t.d(entry.getValue(), value)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return (String) d0.k0(arrayList);
    }

    private final FragmentTransitionImpl resolveSupportImpl() {
        try {
            kotlin.jvm.internal.t.g(FragmentTransitionSupport.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (FragmentTransitionImpl) FragmentTransitionSupport.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void retainValues(@NotNull ArrayMap<String, String> arrayMap, @NotNull ArrayMap<String, View> namedViews) {
        kotlin.jvm.internal.t.i(arrayMap, "<this>");
        kotlin.jvm.internal.t.i(namedViews, "namedViews");
        int size = arrayMap.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    public static final void setViewVisibility(@NotNull List<? extends View> views, int i10) {
        kotlin.jvm.internal.t.i(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i10);
        }
    }

    public static final boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
