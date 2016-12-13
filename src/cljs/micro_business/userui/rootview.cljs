(ns micro-business.userui.rootview
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.userui.state :as state]
   [micro-business.userui.reader :as reader]
   [micro-business.userui.mutate :as mutate]
   [micro-business.userui.signinpage.rootview :as signinpagerootview]))

(enable-console-print!)

(defui RootView
  static om/IQuery
  (query [this]
         (let [signInPageSubQuery (om/get-query signinpagerootview/SignInPageRootView)]
           `[:current-state {:signin-page ~signInPageSubQuery}]))

  Object
  (render [this]
          (let [{:keys [current-state signin-page]} (om/props this)]
            (case current-state
              :require-signin (signinpagerootview/signInPageRootView signin-page)
              (signinpagerootview/signInPageRootView  signin-page)))))

(def rootViewReconciler
  (om/reconciler
   {:state state/state
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! rootViewReconciler
                RootView (gdom/getElement elementName)))

(renderRootView "rootView")
