package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.y;
import e5.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CueGroup implements Bundleable {
    public final y<Cue> cues;

    @UnstableApi
    public final long presentationTimeUs;

    @UnstableApi
    public static final CueGroup EMPTY_TIME_ZERO = new CueGroup(y.q(), 0);
    private static final String FIELD_CUES = Util.intToStringMaxRadix(0);
    private static final String FIELD_PRESENTATION_TIME_US = Util.intToStringMaxRadix(1);

    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<CueGroup> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.common.text.d
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return CueGroup.fromBundle(bundle);
        }
    };

    @UnstableApi
    public CueGroup(List<Cue> list, long j10) {
        this.cues = y.m(list);
        this.presentationTimeUs = j10;
    }

    private static y<Cue> filterOutBitmapCues(List<Cue> list) {
        y.a aVarK = y.k();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10).bitmap == null) {
                aVarK.a(list.get(i10));
            }
        }
        return aVarK.k();
    }

    @UnstableApi
    public static CueGroup fromBundle(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUES);
        return new CueGroup(parcelableArrayList == null ? y.q() : BundleCollectionUtil.fromBundleList(new c(), parcelableArrayList), bundle.getLong(FIELD_PRESENTATION_TIME_US));
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_CUES, BundleCollectionUtil.toBundleArrayList(filterOutBitmapCues(this.cues), new g() { // from class: androidx.media3.common.text.b
            @Override // e5.g
            public final Object apply(Object obj) {
                return ((Cue) obj).toBinderBasedBundle();
            }
        }));
        bundle.putLong(FIELD_PRESENTATION_TIME_US, this.presentationTimeUs);
        return bundle;
    }
}
