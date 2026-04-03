package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

/* JADX INFO: loaded from: classes.dex */
public abstract class Rating implements Bundleable {
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    static final int RATING_TYPE_UNSET = -1;
    static final float RATING_UNSET = -1.0f;
    static final String FIELD_RATING_TYPE = Util.intToStringMaxRadix(0);

    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Rating> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.common.i0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return Rating.fromBundle(bundle);
        }
    };

    Rating() {
    }

    @UnstableApi
    public static Rating fromBundle(Bundle bundle) {
        int i10 = bundle.getInt(FIELD_RATING_TYPE, -1);
        if (i10 == 0) {
            return HeartRating.fromBundle(bundle);
        }
        if (i10 == 1) {
            return PercentageRating.fromBundle(bundle);
        }
        if (i10 == 2) {
            return StarRating.fromBundle(bundle);
        }
        if (i10 == 3) {
            return ThumbRating.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i10);
    }

    public abstract boolean isRated();
}
