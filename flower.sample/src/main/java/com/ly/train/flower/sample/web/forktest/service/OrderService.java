/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.train.flower.sample.web.forktest.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ly.train.flower.common.core.service.ServiceContext;
import com.ly.train.flower.sample.web.dao.OrderDao;
import com.ly.train.flower.sample.web.model.Order;

/**
 * @author fengyu.zhang
 * @date 2019/2/24 17:16
 */
@Service("OrderService")
public class OrderService implements com.ly.train.flower.common.core.service.Service<Integer, List<Order>> {
  @Autowired
  private OrderDao orderDao;

  @Override
  public List<Order> process(Integer message, ServiceContext context) throws Exception {
    List<Order> orders = orderDao.findByCustomerId(message);
    return orders == null ? new ArrayList<Order>() : orders;
  }
}
