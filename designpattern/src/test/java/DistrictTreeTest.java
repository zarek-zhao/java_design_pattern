import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class DistrictTreeTest {


    @Test
    public void test()
    {
        District district1 = new District();
        district1.setDistrictCode("1");
        district1.setDistrictName("一级节点");
        district1.setParentId("root");

        District district2 = new District();
        district2.setDistrictCode("2");
        district2.setDistrictName("二级节点");
        district2.setParentId("1");

        District district3 = new District();
        district3.setDistrictCode("3");
        district3.setDistrictName("二级节点");
        district3.setParentId("1");

        District district4 = new District();
        district4.setDistrictCode("4");
        district4.setDistrictName("三级节点");
        district4.setParentId("2");

        District district5 = new District();
        district5.setDistrictCode("5");
        district5.setDistrictName("四级节点");
        district5.setParentId("4");

        List<District> list = new ArrayList<>();
        list.add(district1);
        list.add(district2);
        list.add(district3);
        list.add(district4);
        list.add(district5);


        Map<String, List<District>> collect1 = list.stream().collect(Collectors.groupingBy(District::getParentId));


        List<District> collect = list.stream().filter(
                e -> "root".equals(e.getParentId())
        ).collect(Collectors.toList());

        District districtTree = collect.get(0);

        List<District> list1 = collect1.get(districtTree.getDistrictCode());
        method(list1,collect1);

        districtTree.setSubDistrict(list1);
        System.out.println("districtTree = " + districtTree);
    }

    private void method(List<District> list,Map<String, List<District>> map){
        for (int i = 0; i < list.size(); i++) {
            District district = list.get(i);
            List<District> list2 = map.get(district.getDistrictCode());
            if(map.get(district.getDistrictCode())!=null){
                method(list2,map);
                district.setSubDistrict(list2);
            }else{
                district.setSubDistrict(list2);
                return;
            }
        }

    }

}
