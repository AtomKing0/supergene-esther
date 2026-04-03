package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private final Context mContext;
    private final Impl mImpl;
    private TextPaint mTempTextPaint;

    @NonNull
    private final TextView mTextView;
    private static final RectF TEMP_RECTF = new RectF();

    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();

    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap<>();
    private int mAutoSizeTextType = 0;
    private boolean mNeedsAutoSizeText = false;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private boolean mHasPresetAutoSizeValues = false;

    @RequiresApi(16)
    private static final class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @DoNotInline
        static int getMaxLines(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    @RequiresApi(18)
    private static final class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static boolean isInLayout(@NonNull View view) {
            return view.isInLayout();
        }
    }

    @RequiresApi(23)
    private static final class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        @DoNotInline
        static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, int i11, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull Impl impl) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                impl.computeAndSetTextDirection(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean isHorizontallyScrollable(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl23();
        }
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t10) {
        try {
            Field textViewField = getTextViewField(str);
            return textViewField == null ? t10 : (T) textViewField.get(obj);
        } catch (IllegalAccessException e10) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e10);
            return t10;
        }
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.mTempTextPaint, i10, alignment, ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = 1;
        int i11 = length - 1;
        int i12 = 0;
        while (i10 <= i11) {
            int i13 = (i10 + i11) / 2;
            if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i10;
                i10 = i14;
            } else {
                i12 = i13 - 1;
                i11 = i12;
            }
        }
        return this.mAutoSizeTextSizesInPx[i12];
    }

    @Nullable
    private static Field getTextViewField(@NonNull String str) {
        try {
            Field declaredField = sTextViewFieldByNameCache.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                sTextViewFieldByNameCache.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e10) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e10);
            return null;
        }
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String str) {
        try {
            Method declaredMethod = sTextViewMethodByNameCache.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                sTextViewMethodByNameCache.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e10) {
            Log.w(TAG, "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    static <T> T invokeAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t10) {
        try {
            return (T) getTextViewMethod(str).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            Log.w(TAG, "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    private void setRawTextSize(float f10) {
        if (f10 != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f10);
            boolean zIsInLayout = Api18Impl.isInLayout(this.mTextView);
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, new Object[0]);
                    }
                } catch (Exception e10) {
                    Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (zIsInLayout) {
                    this.mTextView.forceLayout();
                } else {
                    this.mTextView.requestLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int iFloor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round(this.mAutoSizeMinTextSizeInPx + (i10 * this.mAutoSizeStepGranularityInPx));
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z10 = this.mAutoSizeTextSizesInPx.length > 0;
        this.mHasPresetAutoSizeValues = z10;
        if (z10) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = r0[0];
            this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z10;
    }

    private boolean suggestedSizeFitsInSpace(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.mTextView.getText();
        TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.mTextView)) != null) {
            text = transformation;
        }
        int maxLines = Api16Impl.getMaxLines(this.mTextView);
        initTempTextPaint(i10);
        StaticLayout staticLayoutCreateLayout = createLayout(text, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutCreateLayout.getLineCount() <= maxLines && staticLayoutCreateLayout.getLineEnd(staticLayoutCreateLayout.getLineCount() - 1) == text.length())) && ((float) staticLayoutCreateLayout.getHeight()) <= rectF.bottom;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = f10;
        this.mAutoSizeMaxTextSizeInPx = f11;
        this.mAutoSizeStepGranularityInPx = f12;
        this.mHasPresetAutoSizeValues = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void autoSizeText() {
        if (isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() <= 0 || this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.mImpl.isHorizontallyScrollable(this.mTextView) ? 1048576 : (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = TEMP_RECTF;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fFindLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                    if (fFindLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                        setTextSizeInternal(0, fFindLargestTextSizeWhichFits);
                    }
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    @NonNull
    @VisibleForTesting
    StaticLayout createLayout(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, int i11) {
        return Api23Impl.createStaticLayoutForMeasuring(charSequence, alignment, i10, i11, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    void initTempTextPaint(int i10) {
        TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean isAutoSizeEnabled() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    void loadFromAttributes(@Nullable AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.mContext;
        int[] iArr = R.styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        int i11 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.mAutoSizeTextType = typedArrayObtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i12) ? typedArrayObtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i13) ? typedArrayObtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i14) ? typedArrayObtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i15) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            setupAutoSizeUniformPresetSizes(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!supportsAutoSizeText()) {
            this.mAutoSizeTextType = 0;
            return;
        }
        if (this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            setupAutoSizeText();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i10) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArrCopyOf);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeWithDefaults(int i10) {
        if (supportsAutoSizeText()) {
            if (i10 == 0) {
                clearAutoSizeConfiguration();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setTextSizeInternal(int i10, float f10) {
        Context context = this.mContext;
        setRawTextSize(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    private static class Impl {
        Impl() {
        }

        boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }

        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        }
    }
}
