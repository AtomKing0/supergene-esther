package com.braze.ui.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.braze.models.cards.Card;
import com.braze.models.cards.ICardListener;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$id;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.BrazeFeedManager;
import com.braze.ui.feed.BrazeImageSwitcher;
import com.braze.ui.widget.BaseCardView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFeedCardView<T extends Card> extends BaseCardView<T> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BaseCardView.class);

    public BaseFeedCardView(Context context) {
        BrazeImageSwitcher brazeImageSwitcher;
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
        BrazeImageSwitcher brazeImageSwitcher2 = (BrazeImageSwitcher) findViewById(R$id.com_braze_newsfeed_item_read_indicator_image_switcher);
        this.imageSwitcher = brazeImageSwitcher2;
        if (brazeImageSwitcher2 != null) {
            brazeImageSwitcher2.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.braze.ui.feed.view.b
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return this.f8131a.lambda$new$0();
                }
            });
        }
        if (isUnreadIndicatorEnabled() || (brazeImageSwitcher = this.imageSwitcher) == null) {
            return;
        }
        brazeImageSwitcher.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ View lambda$new$0() {
        return new ImageView(this.applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCard$1() {
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }

    public Card getCard() {
        return this.card;
    }

    protected abstract int getLayoutResource();

    public View getProperViewFromInflatedStub(int i10) {
        ((ViewStub) findViewById(i10)).inflate();
        return findViewById(R$id.com_braze_stubbed_feed_image_view);
    }

    @Override // com.braze.ui.widget.BaseCardView
    protected boolean isClickHandled(Context context, Card card, IAction iAction) {
        return BrazeFeedManager.getInstance().getFeedCardClickActionListener().onFeedCardClicked(context, card, iAction);
    }

    protected abstract void onSetCard(T t10);

    public void setCard(T t10) {
        this.card = t10;
        onSetCard(t10);
        this.card.setListener(new ICardListener() { // from class: com.braze.ui.feed.view.a
            @Override // com.braze.models.cards.ICardListener
            public final void onCardUpdate() {
                this.f8130a.lambda$setCard$1();
            }
        });
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }
}
