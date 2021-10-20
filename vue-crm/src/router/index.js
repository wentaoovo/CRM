import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  },
  // {
  //   path: '/xianwen',
  //   component: Layout,
  //   redirect: '/indexes/index',
  //   children: [{
  //     path: 'index',
  //     name: 'index1',
  //     component: () => import('@/views/xianwen/indexes/index'),
  //     meta: { title: '索引', icon: 'table' }
  //   }]
  // },
  {
    path: '/custment',
    component: Layout,
    children: [{
      path: 'custmenrte',
      name: 'xianwen2',
      component: () => import('@/views/xianwen/custmenrt'),
      meta: { title: '客户', icon: 'el-icon-s-custom' }
    }]
  },
  {
    path: '/contacts',
    component: Layout,
    children: [{
      path: 'contactse',
      name: 'xianwen',
      component: () => import('@/views/xianwen/contacts'),
      meta: { title: '联系人', icon: 'el-icon-user-solid' }
    }]
  },
  {
    path: '/sales',
    component: Layout,
    children: [{
      path: 'drtalies',
      name: 'xianwen4',
      component: () => import('@/views/xianwen/sales'),
      meta: { title: '销售机会', icon: 'el-icon-s-promotion' }
    }]
  },
  {
    path: '/offer',
    component: Layout,
    children: [{
      path: 'offier',
      name: 'xianwen5',
      component: () => import('@/views/xianwen/offer'),
      meta: { title: '报价明细', icon: 'el-icon-document' }
    }]
  },
  {
    path: '/quatation',
    component: Layout,
    children: [{
      path: 'qutations',
      name: 'xianwen3',
      component: () => import('@/views/xianwen/quatation'),
      meta: { title: '报价', icon: 'table' }
    },
  {
    path:'/quatationx',
    component:()=>import('@/views/xianwen/quatationx'),
    name:'quatationx',
    hidden:true,
    meta:{title:'报价明细'}

  }
  ]
  },
  {
    path: '/indent',
    component: Layout,
    children: [
      {
      path: 'index',
      name: 'indent',
      component: () =>import('@/views/indent/index'),
      meta: {title: '订单', icon: 'el-icon-s-order'}
    },
    {
      path: 'viewindex/:id',
      component: () =>import('@/views/indent/viewIndex'),
      name: 'viewindex',
      hidden:true,
      meta: {
        title: '订单-详情'}
    },
    {
      path: 'shipments/:id',
      component: () =>import('@/views/indent/shipments'),
      name: 'shipments',
      hidden:true,
      meta: {
        title: '订单-发货'}
    },
   ]
  },
  {
    path: '/product',
    component: Layout,
    children: [{
      path: 'index',
      name: 'index',
      component: () =>import('@/views/product/index'),
      meta: {title: '产品', icon: 'el-icon-menu'}
    }]
  }, 
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
