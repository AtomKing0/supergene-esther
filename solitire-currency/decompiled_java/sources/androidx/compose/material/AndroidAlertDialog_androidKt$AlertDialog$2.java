package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidAlertDialog_androidKt$AlertDialog$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $confirmButton;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ p<Composer, Integer, k0> $dismissButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ p<Composer, Integer, k0> $text;
    final /* synthetic */ p<Composer, Integer, k0> $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidAlertDialog_androidKt$AlertDialog$2(a<k0> aVar, p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, Shape shape, long j10, long j11, DialogProperties dialogProperties, int i10, int i11) {
        super(2);
        this.$onDismissRequest = aVar;
        this.$confirmButton = pVar;
        this.$modifier = modifier;
        this.$dismissButton = pVar2;
        this.$title = pVar3;
        this.$text = pVar4;
        this.$shape = shape;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$properties = dialogProperties;
        this.$$changed = i10;
        this.$$default = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        AndroidAlertDialog_androidKt.m854AlertDialog6oU6zVQ(this.$onDismissRequest, this.$confirmButton, this.$modifier, this.$dismissButton, this.$title, this.$text, this.$shape, this.$backgroundColor, this.$contentColor, this.$properties, composer, this.$$changed | 1, this.$$default);
    }
}
