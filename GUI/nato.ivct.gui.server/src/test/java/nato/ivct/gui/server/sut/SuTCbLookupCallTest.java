/* Copyright 2020, Reinhard Herzog, Johannes Mulder, Michael Theis (Fraunhofer IOSB)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package nato.ivct.gui.server.sut;

import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.eclipse.scout.rt.testing.server.runner.ServerTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWithSubject("anonymous")
@RunWith(ServerTestRunner.class)
//The following annotation was commented out because it did not
//work with the use of an embedded ActiveMQ. A future developer
//will have to find a solution to this problem
//@RunWithServerSession(ServerSession.class)
public class SuTCbLookupCallTest {

//    protected SuTCbLookupCall createLookupCall() {
//        return new SuTCbLookupCall();
//    }
//
//
//    @Test
//    public void testLookupByAll() {
//        SuTCbLookupCall call = createLookupCall();
//        // TODO [the] fill call
//        List<? extends ILookupRow<String>> data = call.getDataByAll();
//        // TODO [the] verify data
//    }
//
//
//    @Test
//    public void testLookupByKey() {
//        SuTCbLookupCall call = createLookupCall();
//        // TODO [the] fill call
//        List<? extends ILookupRow<String>> data = call.getDataByKey();
//        // TODO [the] verify data
//    }
//
//
//    @Test
//    public void testLookupByText() {
//        SuTCbLookupCall call = createLookupCall();
//        // TODO [the] fill call
//        List<? extends ILookupRow<String>> data = call.getDataByText();
//        // TODO [the] verify data
//    }

    // TODO [the] add test cases
    @Test
    public void testDummy() {

    }
}
