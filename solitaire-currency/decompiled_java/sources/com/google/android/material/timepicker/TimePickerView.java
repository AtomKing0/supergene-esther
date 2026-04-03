package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import e4.h;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Chip f9896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClockHandView f9897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClockFaceView f9898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MaterialButtonToggleGroup f9899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f9900f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.c(TimePickerView.this);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.d(TimePickerView.this);
            return false;
        }
    }

    class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f9903a;

        c(GestureDetector gestureDetector) {
            this.f9903a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f9903a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface d {
    }

    interface e {
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ e c(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ d d(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    private void f() {
        Chip chip = this.f9895a;
        int i10 = e4.f.J;
        chip.setTag(i10, 12);
        this.f9896b.setTag(i10, 10);
        this.f9895a.setOnClickListener(this.f9900f);
        this.f9896b.setOnClickListener(this.f9900f);
        this.f9895a.setAccessibilityClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
        this.f9896b.setAccessibilityClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void g() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f9895a.setOnTouchListener(cVar);
        this.f9896b.setOnTouchListener(cVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.f9896b.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9900f = new a();
        LayoutInflater.from(context).inflate(h.f24860l, this);
        this.f9898d = (ClockFaceView) findViewById(e4.f.f24830k);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(e4.f.f24833n);
        this.f9899e = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.g
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                this.f9918a.e(materialButtonToggleGroup2, i11, z10);
            }
        });
        this.f9895a = (Chip) findViewById(e4.f.f24836q);
        this.f9896b = (Chip) findViewById(e4.f.f24834o);
        this.f9897c = (ClockHandView) findViewById(e4.f.f24831l);
        g();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
    }
}
