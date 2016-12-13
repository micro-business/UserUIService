(ns micro-business.userui.reader
  (:require
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :current-state
  [{:keys [state] :as env} key params]
  (let [st @state
        current-state (st key)]
    {:value current-state}))

(defmethod read :signin-page
  [{:keys [state] :as env} key params]
  (let [st @state
        signin-page (st key)]
    {:value signin-page}))

