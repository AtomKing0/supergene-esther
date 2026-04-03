package com.applovin.impl;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f6773c;

    public r7(View view, com.applovin.impl.sdk.j jVar) {
        this.f6771a = jVar;
        this.f6772b = jVar.I();
        this.f6773c = view;
    }

    public long a(y2 y2Var) {
        long j10;
        if (com.applovin.impl.sdk.n.a()) {
            this.f6772b.a("ViewabilityTracker", "Checking visibility...");
        }
        Point pointB = k0.b(this.f6773c.getContext());
        if (this.f6773c.isShown()) {
            j10 = 0;
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View is hidden");
            }
            j10 = 2;
        }
        if (this.f6773c.getAlpha() < y2Var.b0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View is transparent");
            }
            j10 |= 4;
        }
        Animation animation = this.f6773c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View is animating");
            }
            j10 |= 8;
        }
        if (this.f6773c.getParent() == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "No parent view found");
            }
            j10 |= 16;
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f6773c.getContext(), this.f6773c.getWidth());
        if (iPxToDp < Math.min(y2Var.h0(), pointB.x)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View has width (" + iPxToDp + ") below threshold");
            }
            j10 |= 32;
        }
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f6773c.getContext(), this.f6773c.getHeight());
        if (iPxToDp2 < y2Var.d0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View has height (" + iPxToDp2 + ") below threshold");
            }
            j10 |= 64;
        }
        Rect rect = new Rect(0, 0, pointB.x, pointB.y);
        int[] iArr = {-1, -1};
        this.f6773c.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        Rect rect2 = new Rect(i10, iArr[1], this.f6773c.getWidth() + i10, iArr[1] + this.f6773c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j10 |= 128;
        }
        Activity activityB = this.f6771a.e().b();
        if (activityB != null && !q7.a(this.f6773c, activityB)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6772b.b("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j10 |= 256;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6772b.a("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j10));
        }
        return j10;
    }
}
