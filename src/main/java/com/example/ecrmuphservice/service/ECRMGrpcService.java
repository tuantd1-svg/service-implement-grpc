package com.example.ecrmuphservice.service;

import com.example.commonapi.parameter.enumable.ErrorCode;
import com.example.commongrpc.common.UserBanking;
import com.example.commongrpc.ecrm.ECRMServiceGrpc;
import com.example.commongrpc.ecrm.VerifyUserRequest;
import com.example.commongrpc.ecrm.VerifyUserResponse;
import com.example.ecrmuphservice.model.UserValidatorRequest;
import com.example.ecrmuphservice.model.UserValidatorResponse;
import com.example.ecrmuphservice.repository.EcrmService;
import com.example.loggerapi.utils.LoggerUtils2;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GrpcService
public class ECRMGrpcService extends ECRMServiceGrpc.ECRMServiceImplBase {

    @Autowired
    private EcrmService ecrmService;

    @Override
    public void verifyUser(VerifyUserRequest verifyUserRequest, StreamObserver<VerifyUserResponse> responseStream) {
        LoggerUtils2.info(this.getClass(), "EcrmGrpcService", "pre-verifyUser", verifyUserRequest.toString());
        VerifyUserResponse.Builder builder = VerifyUserResponse.newBuilder();
        try {
            UserValidatorRequest userValidatorRequest = new UserValidatorRequest(verifyUserRequest.getClientNo(), verifyUserRequest.getAcctType(), verifyUserRequest.getPartnerId());
            UserValidatorResponse userValidatorResponse = ecrmService.verifyUser(userValidatorRequest);

            builder.setErrorCode(userValidatorResponse.getErrorCode());
            builder.setErrorMessage(userValidatorResponse.getErrorMessage());
            if (userValidatorResponse.getData() != null) {
                UserBanking userBanking = UserBanking.newBuilder().setAcctType(verifyUserRequest.getAcctType()).setClientCode(verifyUserRequest.getClientNo()).setUsername(userValidatorResponse.getData().getUserName()).build();
                builder.setUserBanking(userBanking);
            }
        } catch (Exception e) {
            builder.setErrorCode(String.valueOf(ErrorCode.FAILURE.getCode()));
            builder.setErrorMessage(ErrorCode.FAILURE.getMessage());
            LoggerUtils2.info(this.getClass(), "EcrmGrpcService", "ex-verifyUser", e.getMessage());
        }
        LoggerUtils2.info(this.getClass(), "EcrmGrpcService", "post-verifyUser", builder.build().toString());
        responseStream.onNext(builder.build());
        responseStream.onCompleted();
    }
}
