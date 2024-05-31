////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.code.aseoha.misc;
//
//import java.util.function.Function;
//import java.util.function.Supplier;
//import net.tardis.mod.client.models.interiordoors.IInteriorDoorRenderer;
//import com.code.aseoha.enums.EnumDoorState;
//
//import static com.code.aseoha.enums.EnumDoorState.CLOSED;
//import static com.code.aseoha.enums.EnumDoorState.ONE;
//
//public interface IDoorType {
//    EnumDoorState[] getValidStates();
//
//    double getRotationForState(EnumDoorState var1);
//
//    void setInteriorDoorModel(IInteriorDoorRenderer var1);
//
//    IInteriorDoorRenderer getInteriorDoorRenderer();
//
//    public static enum EnumDoorType implements IDoorType {
//        CORAL((state) -> {
//            if (state.equals(ONE)) {
//                return 55.0;
//            } else if (state.equals(CLOSED)) {
//                return 0.0;
//            }
//            return 85.0;
//        }, new EnumDoorState[]{CLOSED, ONE, EnumDoorState.BOTH}),
//
//        Function<EnumDoorState, Double> func;
//        EnumDoorState[] validStates;
//        Supplier<Supplier<IInteriorDoorRenderer>> renderer;
//
//        private EnumDoorType(Function func, EnumDoorState... states) {
//            this.validStates = states;
//            this.func = func;
//        }
//
//        public EnumDoorState[] getValidStates() {
//            return this.validStates;
//        }
//
//        public double getRotationForState(EnumDoorState state) {
//            return (Double)this.func.apply(state);
//        }
//
//        public void setInteriorDoorModel(IInteriorDoorRenderer renderer) {
//            this.renderer = () -> {
//                return () -> {
//                    return renderer;
//                };
//            };
//        }
//
//        public IInteriorDoorRenderer getInteriorDoorRenderer() {
//            return (IInteriorDoorRenderer)((Supplier)this.renderer.get()).get();
//        }
//    }
//}
