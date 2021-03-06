//
// Created by raver119 on 20/04/18.
//

#ifndef LIBND4J_DEBUGHELPER_H
#define LIBND4J_DEBUGHELPER_H

#include <pointercast.h>
#include <op_boilerplate.h>
#include <Environment.h>
#include <StringUtils.h>
#include <string>


#ifdef __CUDACC__

#include <cuda.h>
#include <driver_types.h>
#include <cuda_runtime_api.h>
#include <helper_cuda.h>

#endif

namespace nd4j {
    class DebugHelper {
    public:

    // cuda-specific debug functions
#ifdef __CUDACC__
        static FORCEINLINE void checkErrorCode(cudaStream_t *stream, int opNum = 0) {
            if (Environment::getInstance()->isDebug()) {
                cudaError_t res = cudaStreamSynchronize(*stream);
                checkCudaErrors(res);

                if (res != 0) {
                    //PRINT_FIRST("Kernel OpNum failed: [%i]\n", opNum);
                    std::string op = "Kernel OpNum failed: [";
                    op += StringUtils::valueToString<int>(opNum);
                    op += "]";

                    throw std::runtime_error(op);
                }
            }
        }

        static FORCEINLINE void checkErrorCode(cudaStream_t *stream, const char *failMessage = nullptr) {
            cudaError_t res = cudaStreamSynchronize(*stream);
            if (res != 0) {
                if (failMessage == nullptr) {
                    std::string op = "CUDA call ended with error code [" + StringUtils::valueToString<int>(res) + std::string("]");

                } else {
                    std::string op = std::string(failMessage) + std::string("Error code [") + StringUtils::valueToString<int>(res) + std::string("]");
                    throw std::runtime_error(op);
                }
            }
        }
#endif
    };
}


#endif //LIBND4J_DEBUGHELPER_H
