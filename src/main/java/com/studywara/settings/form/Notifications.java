package com.studywara.settings.form;/*
 * @created 16/09/2020 - 4:27 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Notifications {

    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByEmail;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdatedByEmail;

    private boolean studyUpdatedByWeb;

}
