package com.braze.ui.widget;

import android.R;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.R$drawable;
import com.braze.ui.R$string;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.BrazeContentCardUtils;
import com.braze.ui.feed.BrazeImageSwitcher;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: BaseCardView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseCardView<T extends Card> extends RelativeLayout {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    protected final Context applicationContext;

    @Nullable
    protected T card;

    @NotNull
    private final String classLogTag;

    @NotNull
    protected BrazeConfigurationProvider configurationProvider;

    @Nullable
    public BrazeImageSwitcher imageSwitcher;
    private final boolean isUnreadCardVisualIndicatorEnabled;

    /* JADX INFO: compiled from: BaseCardView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @Nullable
        protected final UriAction getUriActionForCard(@NotNull Card card) {
            t.i(card, "card");
            return BrazeContentCardUtils.INSTANCE.getUriActionForCard(card);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$handleCardClick$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class AnonymousClass1 extends v implements h9.a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Handling card click for card: " + this.$card;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$handleCardClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class AnonymousClass2 extends v implements h9.a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Card action is non-null. Attempting to perform action on card: " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$handleCardClick$3, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class AnonymousClass3 extends v implements h9.a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Executing non uri action for click on card: " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$handleCardClick$4, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class AnonymousClass4 extends v implements h9.a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Card action is null. Not performing any click action on card: " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$handleCardClick$5, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class AnonymousClass5 extends v implements h9.a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Card click was handled by custom listener on card: " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.widget.BaseCardView$setCardViewedIndicator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseCardView.kt */
    static final class C12721 extends v implements h9.a<String> {
        public static final C12721 INSTANCE = new C12721();

        C12721() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "imageSwitcher is null. Can't set card viewed indicator.";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCardView(@NotNull Context context) {
        super(context);
        t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        this.applicationContext = applicationContext;
        this.classLogTag = BrazeLogger.getBrazeLogTag(getClass());
        BrazeConfigurationProvider configurationProvider = BrazeInternal.INSTANCE.getConfigurationProvider(context);
        this.configurationProvider = configurationProvider;
        this.isUnreadCardVisualIndicatorEnabled = configurationProvider.isNewsfeedVisualIndicatorOn();
    }

    @Nullable
    protected static final UriAction getUriActionForCard(@NotNull Card card) {
        return Companion.getUriActionForCard(card);
    }

    @NotNull
    public final String getClassLogTag() {
        return this.classLogTag;
    }

    protected final void handleCardClick(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction) {
        t.i(context, "context");
        t.i(card, "card");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new AnonymousClass1(card), 6, (Object) null);
        card.setIndicatorHighlighted(true);
        if (isClickHandled(context, card, iAction)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new AnonymousClass5(card), 7, (Object) null);
            card.logClick();
        } else {
            if (iAction == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new AnonymousClass4(card), 6, (Object) null);
                return;
            }
            card.logClick();
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new AnonymousClass2(card), 6, (Object) null);
            if (iAction instanceof UriAction) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoUri(context, (UriAction) iAction);
            } else {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new AnonymousClass3(card), 7, (Object) null);
                iAction.execute(context);
            }
        }
    }

    protected abstract boolean isClickHandled(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction);

    public final boolean isUnreadIndicatorEnabled() {
        return this.isUnreadCardVisualIndicatorEnabled;
    }

    public final void setCardViewedIndicator(@Nullable BrazeImageSwitcher brazeImageSwitcher, @NotNull Card card) {
        t.i(card, "card");
        if (brazeImageSwitcher == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) C12721.INSTANCE, 6, (Object) null);
            return;
        }
        int i10 = R$string.com_braze_image_is_read_tag_key;
        Object tag = brazeImageSwitcher.getTag(i10);
        if (tag == null) {
            tag = "";
        }
        if (card.isIndicatorHighlighted()) {
            if (t.d(tag, "icon_read")) {
                return;
            }
            if (brazeImageSwitcher.getReadIcon() != null) {
                brazeImageSwitcher.setImageDrawable(brazeImageSwitcher.getReadIcon());
            } else {
                brazeImageSwitcher.setImageResource(R$drawable.com_braze_content_card_icon_read);
            }
            brazeImageSwitcher.setTag(i10, "icon_read");
            return;
        }
        if (t.d(tag, "icon_unread")) {
            return;
        }
        if (brazeImageSwitcher.getUnReadIcon() != null) {
            brazeImageSwitcher.setImageDrawable(brazeImageSwitcher.getUnReadIcon());
        } else {
            brazeImageSwitcher.setImageResource(R$drawable.com_braze_content_card_icon_unread);
        }
        brazeImageSwitcher.setTag(i10, "icon_unread");
    }

    public final void setImageViewToUrl(@NotNull final ImageView imageView, @NotNull String imageUrl, final float f10, @NotNull Card card) {
        t.i(imageView, "imageView");
        t.i(imageUrl, "imageUrl");
        t.i(card, "card");
        int i10 = R$string.com_braze_image_resize_tag_key;
        if (t.d(imageUrl, imageView.getTag(i10))) {
            return;
        }
        if (!(f10 == 0.0f)) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.braze.ui.widget.BaseCardView.setImageViewToUrl.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                        int width = imageView.getWidth();
                        imageView.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (width / f10)));
                        return true;
                    }
                });
            }
        }
        imageView.setImageResource(R.color.transparent);
        Braze.Companion companion = Braze.Companion;
        Context context = getContext();
        t.h(context, "context");
        IBrazeImageLoader imageLoader = companion.getInstance(context).getImageLoader();
        Context context2 = getContext();
        t.h(context2, "context");
        imageLoader.renderUrlIntoCardView(context2, card, imageUrl, imageView, BrazeViewBounds.BASE_CARD_VIEW);
        imageView.setTag(i10, imageUrl);
    }

    public final void setOptionalTextView(@NotNull TextView view, @Nullable String str) {
        t.i(view, "view");
        if (str == null || q.z(str)) {
            view.setText("");
            view.setVisibility(8);
        } else {
            view.setText(str);
            view.setVisibility(0);
        }
    }
}
