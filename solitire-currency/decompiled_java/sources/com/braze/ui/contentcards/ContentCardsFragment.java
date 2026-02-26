package com.braze.ui.contentcards;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$color;
import com.braze.ui.R$id;
import com.braze.ui.R$layout;
import com.braze.ui.R$string;
import com.braze.ui.contentcards.ContentCardsFragment;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import com.braze.ui.contentcards.adapters.EmptyContentCardsAdapter;
import com.braze.ui.contentcards.handlers.DefaultContentCardsUpdateHandler;
import com.braze.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler;
import com.braze.ui.contentcards.handlers.IContentCardsUpdateHandler;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.recycler.ContentCardsDividerItemDecoration;
import com.braze.ui.contentcards.recycler.SimpleItemTouchHelperCallback;
import h9.a;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ContentCardsFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCardsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    public ContentCardAdapter cardAdapter;

    @Nullable
    private RecyclerView contentCardsRecyclerView;

    @Nullable
    private SwipeRefreshLayout contentCardsSwipeLayout;

    @Nullable
    private IEventSubscriber<ContentCardsUpdatedEvent> contentCardsUpdatedSubscriber;

    @Nullable
    private IContentCardsUpdateHandler customContentCardUpdateHandler;

    @Nullable
    private IContentCardsViewBindingHandler customContentCardsViewBindingHandler;

    @Nullable
    private b2 networkUnavailableJob;

    @Nullable
    private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;

    @NotNull
    private EmptyContentCardsAdapter defaultEmptyContentCardsAdapter = new EmptyContentCardsAdapter();

    @NotNull
    private final IContentCardsUpdateHandler defaultContentCardUpdateHandler = new DefaultContentCardsUpdateHandler();

    @NotNull
    private final IContentCardsViewBindingHandler defaultContentCardsViewBindingHandler = new DefaultContentCardsViewBindingHandler();

    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$2, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ ContentCardsUpdatedEvent $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
            super(0);
            this.$event = contentCardsUpdatedEvent;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Updating Content Cards views in response to ContentCardsUpdatedEvent: " + this.$event;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$3, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "ContentCards received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$4, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Old Content Cards was empty, putting up a network spinner and registering the network error message on a delay of 5000 ms.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$5, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    @f(c = "com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$5", f = "ContentCardsFragment.kt", l = {309}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements h9.l<d<? super k0>, Object> {
        int label;

        AnonymousClass5(d<? super AnonymousClass5> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return ContentCardsFragment.this.new AnonymousClass5(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                ContentCardsFragment contentCardsFragment = ContentCardsFragment.this;
                this.label = 1;
                if (contentCardsFragment.networkUnavailable(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super k0> dVar) {
            return ((AnonymousClass5) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$handleContentCardsUpdatedEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    @f(c = "com.braze.ui.contentcards.ContentCardsFragment$handleContentCardsUpdatedEvent$1", f = "ContentCardsFragment.kt", l = {269}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ ContentCardsUpdatedEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContentCardsUpdatedEvent contentCardsUpdatedEvent, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$event = contentCardsUpdatedEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return ContentCardsFragment.this.new AnonymousClass1(this.$event, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                ContentCardsFragment contentCardsFragment = ContentCardsFragment.this;
                ContentCardsUpdatedEvent contentCardsUpdatedEvent = this.$event;
                this.label = 1;
                if (contentCardsFragment.contentCardsUpdate(contentCardsUpdatedEvent, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$networkUnavailable$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    static final class C11512 extends v implements a<String> {
        public static final C11512 INSTANCE = new C11512();

        C11512() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Displaying network unavailable toast.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    static final class C11521 extends v implements a<String> {
        public static final C11521 INSTANCE = new C11521();

        C11521() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Invoked com.braze.ui.contentcards.ContentCardsFragment.onPause()";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$onRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    @f(c = "com.braze.ui.contentcards.ContentCardsFragment$onRefresh$1", f = "ContentCardsFragment.kt", l = {}, m = "invokeSuspend")
    static final class C11531 extends l implements h9.l<d<? super k0>, Object> {
        int label;

        C11531(d<? super C11531> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return ContentCardsFragment.this.new C11531(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            SwipeRefreshLayout contentCardsSwipeLayout = ContentCardsFragment.this.getContentCardsSwipeLayout();
            if (contentCardsSwipeLayout != null) {
                contentCardsSwipeLayout.setRefreshing(false);
            }
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super k0> dVar) {
            return ((C11531) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.ContentCardsFragment$onViewStateRestored$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardsFragment.kt */
    @f(c = "com.braze.ui.contentcards.ContentCardsFragment$onViewStateRestored$1", f = "ContentCardsFragment.kt", l = {}, m = "invokeSuspend")
    static final class C11541 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Bundle $savedInstanceState;
        int label;
        final /* synthetic */ ContentCardsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11541(Bundle bundle, ContentCardsFragment contentCardsFragment, d<? super C11541> dVar) {
            super(2, dVar);
            this.$savedInstanceState = bundle;
            this.this$0 = contentCardsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C11541(this.$savedInstanceState, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            ArrayList<String> stringArrayList;
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            Parcelable parcelable = Build.VERSION.SDK_INT >= 33 ? (Parcelable) this.$savedInstanceState.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", Parcelable.class) : this.$savedInstanceState.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY");
            RecyclerView contentCardsRecyclerView = this.this$0.getContentCardsRecyclerView();
            if (contentCardsRecyclerView != null) {
                RecyclerView.LayoutManager layoutManager = contentCardsRecyclerView.getLayoutManager();
                if (parcelable != null && layoutManager != null) {
                    layoutManager.onRestoreInstanceState(parcelable);
                }
            }
            ContentCardAdapter contentCardAdapter = this.this$0.cardAdapter;
            if (contentCardAdapter != null && (stringArrayList = this.$savedInstanceState.getStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY")) != null) {
                contentCardAdapter.setImpressedCardIds(stringArrayList);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C11541) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(ContentCardsFragment this$0, ContentCardsUpdatedEvent event) {
        t.i(this$0, "this$0");
        t.i(event, "event");
        this$0.handleContentCardsUpdatedEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$2(ContentCardsFragment this$0, SdkDataWipeEvent it) {
        t.i(this$0, "this$0");
        t.i(it, "it");
        this$0.handleContentCardsUpdatedEvent(ContentCardsUpdatedEvent.Companion.getEmptyUpdate());
    }

    protected final void attachSwipeHelperCallback() {
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            new ItemTouchHelper(new SimpleItemTouchHelperCallback(contentCardAdapter)).attachToRecyclerView(this.contentCardsRecyclerView);
        }
    }

    @Nullable
    protected final Object contentCardsUpdate(@NotNull ContentCardsUpdatedEvent contentCardsUpdatedEvent, @NotNull d<? super k0> dVar) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass2(contentCardsUpdatedEvent), 6, (Object) null);
        List<Card> listHandleCardUpdate = getContentCardUpdateHandler().handleCardUpdate(contentCardsUpdatedEvent);
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            contentCardAdapter.replaceCards(listHandleCardUpdate);
        }
        b2 b2Var = this.networkUnavailableJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.networkUnavailableJob = null;
        if (contentCardsUpdatedEvent.isFromOfflineStorage() && contentCardsUpdatedEvent.isTimestampOlderThan(60L)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context contextRequireContext = requireContext();
            t.h(contextRequireContext, "requireContext()");
            companion.getInstance(contextRequireContext).requestContentCardsRefresh();
            if (listHandleCardUpdate.isEmpty()) {
                SwipeRefreshLayout swipeRefreshLayout = this.contentCardsSwipeLayout;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(true);
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass4.INSTANCE, 7, (Object) null);
                b2 b2Var2 = this.networkUnavailableJob;
                if (b2Var2 != null) {
                    b2.a.a(b2Var2, null, 1, null);
                }
                this.networkUnavailableJob = BrazeCoroutineScope.INSTANCE.launchDelayed(b.e(5000L), e1.c(), new AnonymousClass5(null));
                return k0.f35197a;
            }
        }
        if (!listHandleCardUpdate.isEmpty()) {
            ContentCardAdapter contentCardAdapter2 = this.cardAdapter;
            if (contentCardAdapter2 != null) {
                swapRecyclerViewAdapter(contentCardAdapter2);
            }
        } else {
            swapRecyclerViewAdapter(getEmptyCardsAdapter());
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.contentCardsSwipeLayout;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        return k0.f35197a;
    }

    @NotNull
    public final IContentCardsUpdateHandler getContentCardUpdateHandler() {
        IContentCardsUpdateHandler iContentCardsUpdateHandler = this.customContentCardUpdateHandler;
        return iContentCardsUpdateHandler == null ? this.defaultContentCardUpdateHandler : iContentCardsUpdateHandler;
    }

    @Nullable
    public final RecyclerView getContentCardsRecyclerView() {
        return this.contentCardsRecyclerView;
    }

    @Nullable
    protected final SwipeRefreshLayout getContentCardsSwipeLayout() {
        return this.contentCardsSwipeLayout;
    }

    @NotNull
    public final IContentCardsViewBindingHandler getContentCardsViewBindingHandler() {
        IContentCardsViewBindingHandler iContentCardsViewBindingHandler = this.customContentCardsViewBindingHandler;
        return iContentCardsViewBindingHandler == null ? this.defaultContentCardsViewBindingHandler : iContentCardsViewBindingHandler;
    }

    @NotNull
    protected final RecyclerView.Adapter<?> getEmptyCardsAdapter() {
        return this.defaultEmptyContentCardsAdapter;
    }

    protected final void handleContentCardsUpdatedEvent(@NotNull ContentCardsUpdatedEvent event) {
        t.i(event, "event");
        kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, e1.c(), null, new AnonymousClass1(event, null), 2, null);
    }

    protected final void initializeRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        Context contextRequireContext = requireContext();
        t.h(contextRequireContext, "requireContext()");
        ContentCardAdapter contentCardAdapter = new ContentCardAdapter(contextRequireContext, linearLayoutManager, new ArrayList(), getContentCardsViewBindingHandler());
        this.cardAdapter = contentCardAdapter;
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(contentCardAdapter);
        }
        RecyclerView recyclerView2 = this.contentCardsRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        attachSwipeHelperCallback();
        RecyclerView recyclerView3 = this.contentCardsRecyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView3 != null ? recyclerView3.getItemAnimator() : null;
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        RecyclerView recyclerView4 = this.contentCardsRecyclerView;
        if (recyclerView4 != null) {
            Context contextRequireContext2 = requireContext();
            t.h(contextRequireContext2, "requireContext()");
            recyclerView4.addItemDecoration(new ContentCardsDividerItemDecoration(contextRequireContext2));
        }
    }

    @Nullable
    protected final Object networkUnavailable(@NotNull d<? super k0> dVar) {
        Context applicationContext;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11512.INSTANCE, 6, (Object) null);
        Context context = getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            Toast.makeText(applicationContext, applicationContext.getString(R$string.com_braze_feed_connection_error_title), 1).show();
        }
        swapRecyclerViewAdapter(getEmptyCardsAdapter());
        SwipeRefreshLayout swipeRefreshLayout = this.contentCardsSwipeLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        return k0.f35197a;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        t.i(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.com_braze_content_cards, viewGroup, false);
        this.contentCardsRecyclerView = (RecyclerView) viewInflate.findViewById(R$id.com_braze_content_cards_recycler);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R$id.braze_content_cards_swipe_container);
        this.contentCardsSwipeLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.contentCardsSwipeLayout;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setColorSchemeResources(R$color.com_braze_content_cards_swipe_refresh_color_1, R$color.com_braze_content_cards_swipe_refresh_color_2, R$color.com_braze_content_cards_swipe_refresh_color_3, R$color.com_braze_content_cards_swipe_refresh_color_4);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11521.INSTANCE, 6, (Object) null);
        Braze.Companion companion = Braze.Companion;
        Context contextRequireContext = requireContext();
        t.h(contextRequireContext, "requireContext()");
        companion.getInstance(contextRequireContext).removeSingleSubscription(this.contentCardsUpdatedSubscriber, ContentCardsUpdatedEvent.class);
        Context contextRequireContext2 = requireContext();
        t.h(contextRequireContext2, "requireContext()");
        companion.getInstance(contextRequireContext2).removeSingleSubscription(this.sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
        b2 b2Var = this.networkUnavailableJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.networkUnavailableJob = null;
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            contentCardAdapter.markOnScreenCardsAsRead();
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        Braze.Companion companion = Braze.Companion;
        Context contextRequireContext = requireContext();
        t.h(contextRequireContext, "requireContext()");
        companion.getInstance(contextRequireContext).requestContentCardsRefresh();
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, 2500L, null, new C11531(null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Braze.Companion companion = Braze.Companion;
        Context contextRequireContext = requireContext();
        t.h(contextRequireContext, "requireContext()");
        companion.getInstance(contextRequireContext).removeSingleSubscription(this.contentCardsUpdatedSubscriber, ContentCardsUpdatedEvent.class);
        if (this.contentCardsUpdatedSubscriber == null) {
            this.contentCardsUpdatedSubscriber = new IEventSubscriber() { // from class: i0.b
                @Override // com.braze.events.IEventSubscriber
                public final void trigger(Object obj) {
                    ContentCardsFragment.onResume$lambda$0(this.f26565a, (ContentCardsUpdatedEvent) obj);
                }
            };
        }
        IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber = this.contentCardsUpdatedSubscriber;
        if (iEventSubscriber != null) {
            Context contextRequireContext2 = requireContext();
            t.h(contextRequireContext2, "requireContext()");
            companion.getInstance(contextRequireContext2).subscribeToContentCardsUpdates(iEventSubscriber);
        }
        Context contextRequireContext3 = requireContext();
        t.h(contextRequireContext3, "requireContext()");
        companion.getInstance(contextRequireContext3).requestContentCardsRefreshFromCache();
        Context contextRequireContext4 = requireContext();
        t.h(contextRequireContext4, "requireContext()");
        companion.getInstance(contextRequireContext4).removeSingleSubscription(this.sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
        if (this.sdkDataWipeEventSubscriber == null) {
            this.sdkDataWipeEventSubscriber = new IEventSubscriber() { // from class: i0.c
                @Override // com.braze.events.IEventSubscriber
                public final void trigger(Object obj) {
                    ContentCardsFragment.onResume$lambda$2(this.f26566a, (SdkDataWipeEvent) obj);
                }
            };
        }
        IEventSubscriber<SdkDataWipeEvent> iEventSubscriber2 = this.sdkDataWipeEventSubscriber;
        if (iEventSubscriber2 != null) {
            Context contextRequireContext5 = requireContext();
            t.h(contextRequireContext5, "requireContext()");
            companion.getInstance(contextRequireContext5).addSingleSynchronousSubscription(iEventSubscriber2, SdkDataWipeEvent.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        RecyclerView.LayoutManager layoutManager;
        t.i(outState, "outState");
        super.onSaveInstanceState(outState);
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            outState.putParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", layoutManager.onSaveInstanceState());
        }
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            outState.putStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY", new ArrayList<>(contentCardAdapter.getImpressedCardIds()));
        }
        IContentCardsViewBindingHandler iContentCardsViewBindingHandler = this.customContentCardsViewBindingHandler;
        if (iContentCardsViewBindingHandler != null) {
            outState.putParcelable("VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY", iContentCardsViewBindingHandler);
        }
        IContentCardsUpdateHandler iContentCardsUpdateHandler = this.customContentCardUpdateHandler;
        if (iContentCardsUpdateHandler != null) {
            outState.putParcelable("UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY", iContentCardsUpdateHandler);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            int i10 = Build.VERSION.SDK_INT;
            IContentCardsUpdateHandler iContentCardsUpdateHandler = i10 >= 33 ? (IContentCardsUpdateHandler) bundle.getParcelable("UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY", IContentCardsUpdateHandler.class) : (IContentCardsUpdateHandler) bundle.getParcelable("UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY");
            if (iContentCardsUpdateHandler != null) {
                setContentCardUpdateHandler(iContentCardsUpdateHandler);
            }
            IContentCardsViewBindingHandler iContentCardsViewBindingHandler = i10 >= 33 ? (IContentCardsViewBindingHandler) bundle.getParcelable("VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY", IContentCardsViewBindingHandler.class) : (IContentCardsViewBindingHandler) bundle.getParcelable("VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY");
            if (iContentCardsViewBindingHandler != null) {
                setContentCardsViewBindingHandler(iContentCardsViewBindingHandler);
            }
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, e1.c(), null, new C11541(bundle, this, null), 2, null);
        }
        initializeRecyclerView();
    }

    public final void setContentCardUpdateHandler(@Nullable IContentCardsUpdateHandler iContentCardsUpdateHandler) {
        this.customContentCardUpdateHandler = iContentCardsUpdateHandler;
    }

    public final void setContentCardsViewBindingHandler(@Nullable IContentCardsViewBindingHandler iContentCardsViewBindingHandler) {
        this.customContentCardsViewBindingHandler = iContentCardsViewBindingHandler;
    }

    protected final void swapRecyclerViewAdapter(@NotNull RecyclerView.Adapter<?> newAdapter) {
        t.i(newAdapter, "newAdapter");
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (recyclerView == null || recyclerView.getAdapter() == newAdapter) {
            return;
        }
        recyclerView.setAdapter(newAdapter);
    }
}
