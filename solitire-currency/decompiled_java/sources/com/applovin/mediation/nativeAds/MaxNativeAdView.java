package com.applovin.mediation.nativeAds;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlayer;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinStarRatingView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u2;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class MaxNativeAdView extends FrameLayout {
    public static final String MEDIUM_TEMPLATE_1 = "medium_template_1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f7972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f7973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f7974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Button f7975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FrameLayout f7977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewGroup f7978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FrameLayout f7979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewGroup f7980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ViewGroup f7981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final FrameLayout f7982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.applovin.impl.mediation.ads.b f7983m;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f7984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7985b;

        a(WeakReference weakReference, ViewGroup viewGroup) {
            this.f7984a = weakReference;
            this.f7985b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f7984a.get();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                j.f7084v0.I();
                if (n.a()) {
                    j.f7084v0.I().k("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                }
            } else {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.f7984a.clear();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7985b.getLayoutParams();
            layoutParams.height = ((View) this.f7985b.getParent()).getWidth();
            this.f7985b.setLayoutParams(layoutParams);
            return true;
        }
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
    }

    @Nullable
    public com.applovin.impl.mediation.ads.b getAdViewTracker() {
        return this.f7983m;
    }

    public TextView getAdvertiserTextView() {
        return this.f7973c;
    }

    public TextView getBodyTextView() {
        return this.f7974d;
    }

    public Button getCallToActionButton() {
        return this.f7975e;
    }

    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList(5);
        TextView textView = this.f7972b;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f7973c;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.f7974d;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        Button button = this.f7975e;
        if (button != null) {
            arrayList.add(button);
        }
        ImageView imageView = this.f7976f;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        return arrayList;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.f7977g;
    }

    public ImageView getIconImageView() {
        return this.f7976f;
    }

    public View getMainView() {
        return this.f7971a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.f7982l;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.f7981k;
        return viewGroup != null ? viewGroup : this.f7982l;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.f7979i;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.f7978h;
        return viewGroup != null ? viewGroup : this.f7979i;
    }

    public ViewGroup getStarRatingContentViewGroup() {
        return this.f7980j;
    }

    public TextView getTitleTextView() {
        return this.f7972b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.applovin.impl.mediation.ads.b bVar = this.f7983m;
        if (bVar != null) {
            bVar.c();
        }
        if (isHardwareAccelerated()) {
            return;
        }
        n.j("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
    }

    public void recycle() {
        setOnClickListener(null);
        com.applovin.impl.mediation.ads.b bVar = this.f7983m;
        if (bVar != null) {
            bVar.a();
            this.f7983m = null;
        }
        View view = this.f7971a;
        if (view == null || view.getParent() == this) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f7971a.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            removeView(viewGroup);
        }
        addView(this.f7971a);
    }

    public void render(u2 u2Var, a.InterfaceC0165a interfaceC0165a, j jVar) {
        recycle();
        if (!u2Var.o0().get() || !u2Var.m0().get()) {
            this.f7983m = new com.applovin.impl.mediation.ads.b(u2Var, this, interfaceC0165a, jVar);
        }
        final MaxNativeAd nativeAd = u2Var.getNativeAd();
        if (u2Var.p0() && nativeAd.isContainerClickable()) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("MaxNativeAdView", "Enabling container click");
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.nativeAds.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nativeAd.performClick();
                }
            });
        }
        if (StringUtils.isValidString(u2Var.n0())) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("MaxNativeAdView", "Rendering template ad view");
            }
            b(nativeAd);
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().a("MaxNativeAdView", "Rendering custom ad view");
        }
        a(nativeAd);
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    private int a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_small_template_1;
            }
            if (MEDIUM_TEMPLATE_1.equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid format: " + str);
        }
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return "vertical_banner_template".equals(str) ? R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? R.layout.max_native_ad_vertical_media_banner_view : R.layout.max_native_ad_banner_view;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return "vertical_leader_template".equals(str) ? R.layout.max_native_ad_vertical_leader_view : R.layout.max_native_ad_leader_view;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return R.layout.max_native_ad_mrec_view;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private void b(MaxNativeAd maxNativeAd) {
        if (this.f7972b == null) {
            n.j("MaxNativeAdView", "Rendering template ad view without title text view");
        } else if (StringUtils.isValidString(maxNativeAd.getTitle())) {
            this.f7972b.setText(maxNativeAd.getTitle());
        } else {
            this.f7972b.setVisibility(8);
        }
        if (this.f7973c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.f7973c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.f7973c.setVisibility(8);
            }
        }
        if (this.f7974d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.f7974d.setText(maxNativeAd.getBody());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.f7974d.setVisibility(8);
            } else {
                this.f7974d.setVisibility(4);
            }
        }
        if (this.f7975e != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.f7975e.setText(maxNativeAd.getCallToAction());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.f7975e.setVisibility(8);
            } else {
                this.f7975e.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.f7977g;
        if (frameLayout != null) {
            if (icon == null || this.f7976f == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.f7977g.removeAllViews();
                    this.f7977g.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.f7976f.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null || !StringUtils.isValidString(icon.getUri().toString())) {
                this.f7977g.setVisibility(8);
            } else {
                ImageViewUtils.setAndDownscaleImageUri(this.f7976f, icon.getUri());
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.f7979i;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f7979i.addView(optionsView);
            this.f7979i.bringToFront();
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.f7982l != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f7982l.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.f7982l.setVisibility(8);
            }
        }
        if (this.f7980j != null) {
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                this.f7980j.removeAllViews();
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f7980j.addView(appLovinStarRatingView);
            } else {
                this.f7980j.setVisibility(8);
            }
        }
        b();
        postDelayed(new Runnable() { // from class: com.applovin.mediation.nativeAds.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f8031a.a();
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Deprecated
    public MaxNativeAdView(@Nullable MaxNativeAd maxNativeAd, @Nullable String str, Activity activity) {
        this(maxNativeAd, str, activity.getApplicationContext());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaxNativeAdView(@Nullable MaxNativeAd maxNativeAd, @Nullable String str, Context context) {
        MaxNativeAdViewBinder.Builder iconContentViewId = new MaxNativeAdViewBinder.Builder(-1).setTemplateType(str).setTitleTextViewId(R.id.applovin_native_title_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setCallToActionButtonId(R.id.applovin_native_cta_button).setIconImageViewId(R.id.applovin_native_icon_image_view).setIconContentViewId(R.id.applovin_native_icon_view);
        int i10 = R.id.applovin_native_options_view;
        MaxNativeAdViewBinder.Builder starRatingContentViewGroupId = iconContentViewId.setOptionsContentViewGroupId(i10).setOptionsContentFrameLayoutId(i10).setStarRatingContentViewGroupId(R.id.applovin_native_star_rating_view);
        int i11 = R.id.applovin_native_media_content_view;
        this(maxNativeAd, starRatingContentViewGroupId.setMediaContentViewGroupId(i11).setMediaContentFrameLayoutId(i11).build(), context);
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(@Nullable MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        int iA;
        super(context);
        boolean z10 = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        View view = maxNativeAdViewBinder.mainView;
        if (view != null) {
            this.f7971a = view;
        } else {
            if (z10) {
                iA = a(maxNativeAdViewBinder.templateType, format);
            } else {
                iA = maxNativeAdViewBinder.layoutResourceId;
            }
            this.f7971a = LayoutInflater.from(context).inflate(iA, (ViewGroup) this, false);
        }
        addView(this.f7971a);
        this.f7972b = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.f7973c = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.f7974d = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.f7975e = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        this.f7976f = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.f7977g = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.f7978h = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.f7979i = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.f7980j = (ViewGroup) findViewById(maxNativeAdViewBinder.starRatingContentViewGroupId);
        this.f7981k = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.f7982l = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        if (maxNativeAd != null) {
            b(maxNativeAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        setSelected(true);
    }

    private void a(MaxNativeAd maxNativeAd) {
        TextView textView = this.f7972b;
        if (textView != null) {
            textView.setText(maxNativeAd.getTitle());
        }
        TextView textView2 = this.f7974d;
        if (textView2 != null) {
            textView2.setText(maxNativeAd.getBody());
        }
        TextView textView3 = this.f7973c;
        if (textView3 != null) {
            textView3.setText(maxNativeAd.getAdvertiser());
        }
        Button button = this.f7975e;
        if (button != null) {
            button.setText(maxNativeAd.getCallToAction());
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.f7976f;
        if (imageView != null) {
            if (icon != null) {
                if (icon.getDrawable() != null) {
                    this.f7976f.setImageDrawable(icon.getDrawable());
                } else if (icon.getUri() != null) {
                    ImageViewUtils.setAndDownscaleImageUri(this.f7976f, icon.getUri());
                } else {
                    this.f7976f.setImageDrawable(null);
                }
            } else {
                imageView.setImageDrawable(null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.f7981k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f7981k.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.f7978h;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f7978h.addView(optionsView);
                this.f7978h.bringToFront();
            }
        }
        ViewGroup viewGroup3 = this.f7980j;
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f7980j.addView(appLovinStarRatingView);
            }
        }
    }

    private void b() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.applovin_native_inner_parent_layout);
        if (viewGroup == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new a(new WeakReference(viewTreeObserver), viewGroup));
        }
    }
}
