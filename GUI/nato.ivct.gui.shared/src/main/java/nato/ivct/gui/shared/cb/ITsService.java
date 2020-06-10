/* Copyright 2020, Michael Theis (Fraunhofer IOSB)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package nato.ivct.gui.shared.cb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.data.form.fields.tablefield.AbstractTableFieldBeanData;

import nato.ivct.gui.shared.ts.TsFormData;


@TunnelToServer
public interface ITsService extends IService {

    TsFormData load(TsFormData formData);


    Set<String> loadTestSuites();


    AbstractTableFieldBeanData loadRequirementsForTc(Set<String> testcases);


    Set<String> getTsForIr(Set<String> irSet);


    HashMap<String, HashSet<String>> getTcListForBadge(String cbId);


    HashMap<String, String> getIrForTc(String tcId);
}
