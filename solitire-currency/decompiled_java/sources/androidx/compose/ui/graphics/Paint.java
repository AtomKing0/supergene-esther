package androidx.compose.ui.graphics;

import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Paint.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Paint {
    @NotNull
    android.graphics.Paint asFrameworkPaint();

    float getAlpha();

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU */
    int mo1481getBlendMode0nO6VwU();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo1482getColor0d7_KjU();

    @Nullable
    ColorFilter getColorFilter();

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I */
    int mo1483getFilterQualityfv9h1I();

    @Nullable
    PathEffect getPathEffect();

    @Nullable
    Shader getShader();

    /* JADX INFO: renamed from: getStrokeCap-KaPHkGw */
    int mo1484getStrokeCapKaPHkGw();

    /* JADX INFO: renamed from: getStrokeJoin-LxFBmk8 */
    int mo1485getStrokeJoinLxFBmk8();

    float getStrokeMiterLimit();

    float getStrokeWidth();

    /* JADX INFO: renamed from: getStyle-TiuSbCo */
    int mo1486getStyleTiuSbCo();

    boolean isAntiAlias();

    void setAlpha(float f10);

    void setAntiAlias(boolean z10);

    /* JADX INFO: renamed from: setBlendMode-s9anfk8 */
    void mo1487setBlendModes9anfk8(int i10);

    /* JADX INFO: renamed from: setColor-8_81llA */
    void mo1488setColor8_81llA(long j10);

    void setColorFilter(@Nullable ColorFilter colorFilter);

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo */
    void mo1489setFilterQualityvDHp3xo(int i10);

    void setPathEffect(@Nullable PathEffect pathEffect);

    void setShader(@Nullable Shader shader);

    /* JADX INFO: renamed from: setStrokeCap-BeK7IIE */
    void mo1490setStrokeCapBeK7IIE(int i10);

    /* JADX INFO: renamed from: setStrokeJoin-Ww9F2mQ */
    void mo1491setStrokeJoinWw9F2mQ(int i10);

    void setStrokeMiterLimit(float f10);

    void setStrokeWidth(float f10);

    /* JADX INFO: renamed from: setStyle-k9PVt8s */
    void mo1492setStylek9PVt8s(int i10);
}
