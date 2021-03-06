/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.ejb30.bb.session.stateful.timeout.annotated;

import java.util.concurrent.TimeUnit;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import com.sun.ts.tests.ejb30.lite.stateful.timeout.common.StatefulTimeoutBeanBase;
import com.sun.ts.tests.ejb30.lite.stateful.timeout.common.StatefulTimeoutIF;
import com.sun.ts.tests.ejb30.lite.stateful.timeout.common.StatefulTimeoutRemoteIF;

@Stateful
@StatefulTimeout(value = StatefulTimeoutIF.TIMEOUT_SECONDS, unit = TimeUnit.SECONDS)
@Local(StatefulTimeoutIF.class)
@Remote(StatefulTimeoutRemoteIF.class)
@LocalBean
public class SecondUnitBean extends StatefulTimeoutBeanBase {
}
