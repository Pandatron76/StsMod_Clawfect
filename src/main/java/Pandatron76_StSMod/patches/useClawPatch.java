package Pandatron76_StSMod.patches;

import Pandatron76_StSMod.actions.defect.ClawTagAction;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.defect.GashAction;

import com.megacrit.cardcrawl.cards.blue.Claw;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.NewExpr;

public class useClawPatch {

    @SpirePatch(clz = Claw.class, method = "use")
    public static class Update {

        public static ExprEditor Instrument() {

            return new ExprEditor() {
                @Override
                public void edit(NewExpr e) throws CannotCompileException {
                    // TODO: In the future, the 'GashAction' should be updated to check for card with the 'CLAW' tag.
                    if (e.getClassName().equals(GashAction.class.getName())) {
                        e.replace(
                                "{" +
                                        "$_ = new " + ClawTagAction.class.getName() +
                                        "($1, $2);" +
                                        "}");
                    }
                }
            };
        }
    }
}
