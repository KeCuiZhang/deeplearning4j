/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.shape;

import lombok.extern.slf4j.Slf4j;
import onnx.OnnxProto3;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.ShapeOp;
import org.tensorflow.framework.AttrValue;
import org.tensorflow.framework.GraphDef;
import org.tensorflow.framework.NodeDef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Reshape function
 *
 * @author Adam Gibson
 */
@Slf4j
public class Rank extends ShapeOp {


    public Rank(SameDiff sameDiff, DifferentialFunction i_v) {
        super(sameDiff, i_v, false);
    }

    public Rank(SameDiff sameDiff, DifferentialFunction i_v,Object[] extraArgs, int[] shape1) {
        super(sameDiff, i_v, null, false, extraArgs);
    }

    public Rank() {}

    public Rank(INDArray x, INDArray z) {
        super(x, z);
    }

    public Rank(INDArray x, INDArray z, long n) {
        super(x, z, n);
    }

    public Rank(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public Rank(INDArray x) {
        super(x);
    }

    @Override
    public void exec(int... dimensions) {
        exec();
    }



    @Override
    public void initFromTensorFlow(NodeDef nodeDef, SameDiff initWith, Map<String, AttrValue> attributesForNode, GraphDef graph) {

    }

    @Override
    public void initFromOnnx(OnnxProto3.NodeProto node, SameDiff initWith, Map<String, OnnxProto3.AttributeProto> attributesForNode, OnnxProto3.GraphProto graph) {

    }

    @Override
    public int opNum() {
        return 0;
    }

    @Override
    public String opName() {
        return "rank";
    }

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx found for op " + opName());
    }

    @Override
    public String tensorflowName() {
        return "Rank";
    }

    @Override
    public List<int[]> calculateOutputShape() {
        List<int[]> ret = new ArrayList<>();
        ret.add(new int[]{1,1});
        return ret;
    }

    @Override
    public int[] getResultShape() {
        return new int[] {1,1};
    }

    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v) {
        DifferentialFunction ret = this;

        return Collections.singletonList(ret);
    }

}
