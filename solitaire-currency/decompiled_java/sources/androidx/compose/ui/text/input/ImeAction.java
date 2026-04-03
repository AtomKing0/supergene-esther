package androidx.compose.ui.text.input;

import androidx.webkit.Profile;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImeAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImeAction {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Default = m3457constructorimpl(1);
    private static final int None = m3457constructorimpl(0);
    private static final int Go = m3457constructorimpl(2);
    private static final int Search = m3457constructorimpl(3);
    private static final int Send = m3457constructorimpl(4);
    private static final int Previous = m3457constructorimpl(5);
    private static final int Next = m3457constructorimpl(6);
    private static final int Done = m3457constructorimpl(7);

    /* JADX INFO: compiled from: ImeAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m3463getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* JADX INFO: renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m3464getDoneeUduSuo() {
            return ImeAction.Done;
        }

        /* JADX INFO: renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m3465getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* JADX INFO: renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m3466getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* JADX INFO: renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m3467getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m3468getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m3469getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* JADX INFO: renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m3470getSendeUduSuo() {
            return ImeAction.Send;
        }
    }

    private /* synthetic */ ImeAction(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m3456boximpl(int i10) {
        return new ImeAction(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3458equalsimpl(int i10, Object obj) {
        return (obj instanceof ImeAction) && i10 == ((ImeAction) obj).m3462unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3459equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3461toStringimpl(int i10) {
        return m3459equalsimpl0(i10, None) ? "None" : m3459equalsimpl0(i10, Default) ? Profile.DEFAULT_PROFILE_NAME : m3459equalsimpl0(i10, Go) ? "Go" : m3459equalsimpl0(i10, Search) ? "Search" : m3459equalsimpl0(i10, Send) ? "Send" : m3459equalsimpl0(i10, Previous) ? "Previous" : m3459equalsimpl0(i10, Next) ? "Next" : m3459equalsimpl0(i10, Done) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3458equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3460hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3461toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3462unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3457constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3460hashCodeimpl(int i10) {
        return i10;
    }
}
