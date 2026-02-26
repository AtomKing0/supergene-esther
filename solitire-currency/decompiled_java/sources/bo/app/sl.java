package bo.app;

import com.braze.enums.CardType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3867a;

    static {
        int[] iArr = new int[CardType.values().length];
        try {
            iArr[CardType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[CardType.CAPTIONED_IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[CardType.SHORT_NEWS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[CardType.TEXT_ANNOUNCEMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[CardType.CONTROL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f3867a = iArr;
    }
}
