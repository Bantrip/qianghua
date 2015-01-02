逼斗士Java后台
======
#启动演示
1. 执行bin下refresh-db.sh，初始化数据
2. eclipse 下运行src/test/java/com/banyou/backend/BackendServer
3  执行bin下h2.sh，查看控制台

#权限
角色
1.admin 大王，无敌模式
2.manager 网站运营
3.merchant 商家
4.user     网站用户





#路径
1. base 路径 127.0.0.1:8081/bidoushi/

2. 商品
    1. list get 127.0.0.1:8081/bidoushi/product                     done 
    2. create get 127.0.0.1:8081/bidoushi/product/create            done
    2. createSubmit post 127.0.0.1:8081/bidoushi/product/create
    3. update get 127.0.0.1:8081/bidoushi/product/update/{id}       done
    4. updateSubmit post 127.0.0.1:8081/bidoushi/product/update/{id}
    5. delete get 127.0.0.1:8081/bidoushi/product/delete/{id}       done

3. dest 
    1. list get 127.0.0.1:8081/bidoushi/dest (json dest.json or $.getJSON(dest))
    2. product dest list get 127.0.0.1:8081/bidoushi/dest.json?productId={id} //暂时不需要
    3. 
    
4. tag
    1. list.json get 127.0.0.1:8081/bidoushi/tag
	2. product tag list get 127.0.0.1:8081/bidoushi/tag.json?productId={id}//暂时不需要

5. upload
    1. uploadfile post 127.0.0.1:8081/bidoushi/upload
    2. downloadfile get 127.0.0.1/8081/bidoushi/download
    
6. 用户权限加入

