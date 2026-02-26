package com.braze.ui.contentcards.managers;

import com.braze.ui.contentcards.listeners.DefaultContentCardsActionListener;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: BrazeContentCardsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeContentCardsManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<BrazeContentCardsManager> instance$delegate = n.a(BrazeContentCardsManager$Companion$instance$2.INSTANCE);

    @Nullable
    private IContentCardsActionListener contentCardsActionListener = new DefaultContentCardsActionListener();

    /* JADX INFO: compiled from: BrazeContentCardsManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final BrazeContentCardsManager getInstance() {
            return (BrazeContentCardsManager) BrazeContentCardsManager.instance$delegate.getValue();
        }
    }

    @Nullable
    public final IContentCardsActionListener getContentCardsActionListener() {
        return this.contentCardsActionListener;
    }
}
