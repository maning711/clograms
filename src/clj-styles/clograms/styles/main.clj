(ns clograms.styles.main)

(def color {:super-light-grey "#EEE"
            :light-grey "rgb(60,60,60)"
            :dark-grey "#2f2f2f"
            :green "#98971a"
            :red "#cc241d"

            :code-background "#a89984"
            :selection "#665c54"
            :side-bar "#3c3836"
            :background "#504945"

            :project-node "#458588"
            :namespace-node "#b16286"
            :var-node "#689d6a"

            :main-font "#eee"
            })

(def border-radius "3px")

(def diagram
  [:.diagram-layer {:width "100%"
                    :height "100%"
                    :position :absolute
                    :background (color :background)}
   ["> *" {:height "100%"}]
   [:.custom-node {:padding "5px"
                   :border-radius border-radius
                   :display :flex
                   :align-items :center}]
   [:.port {:display :inline-block
            :width "10px"
            :height "10px"
            :margin "5px"
            :border-radius border-radius
            :background-color :red
            :color :transparent}
    [:&:hover {:background-color (str "yellow !important")
               :cursor :crosshair}]]
   [:.node-body {:display :inline-block}]
   [:.project-node {:border (str "2px solid " (color :project-node))}
    [:.port {:background-color (color :project-node)}]]
   [:.namespace-node {:border  (str "2px solid " (color :namespace-node))}
    [:.port {:background-color (color :namespace-node)}]]
   [:.var-node {:border (str "2px solid " (color :var-node))}
    [:.port {:background-color (color :var-node)}]
    [:.var-name {:font-weight :bold}]
    [:.source {:max-width "500px"
               :font-size "10px"
               :max-height "200px"
               :background-color (color :main-font)}]]])

(def general
  [:body {:font-size "11px"
          :color (str (color :main-font) " !important")}
   [:.context-menu {:background (color :side-bar)
                    :min-width "200px"
                    :border-radius border-radius}
    [:ul
     [:li {:padding-left "10px"
           :padding-top "10px"
           :cursor :pointer}]]]
   [:ul {:list-style :none
         :padding 0}]
   [:.project-name {}]
   [:.namespace-name {}]
   [:.var-name {}]
   [:.draggable-entity
    {:padding "5px"
     :border-radius border-radius
     :margin "5px"
     :background-color (color :background)
     :font-size "11px"}]
   [:.draggable-project {:border  (str "1px solid " (color :project-node))}
    [:&.main-project {:border-width "2px"}]]
   [:.draggable-namespace {:border (str "1px solid " (color :namespace-node))}]
   [:.draggable-var {:border (str "1px solid " (color :var-node))}
    [:.var {:display :inline-block
            :margin-right "4px"
            :width "7px"
            :height "7px"
            :border-radius border-radius}
     [:&.private {:background-color (color :red)}]
     [:&.public {:background-color (color :green)}]]]])

(def entity-selector
  [:.entity-selector {:position :absolute
                      :z-index 10
                      :left "50%"
                      :top "3%"
                      :margin-left "-300px"}
   [:.project-name {:margin-left "3px"
                    :opacity 0.5}]
   [:input {:background-color (color :side-bar)
            :color (color :super-light-grey)}]
   [:.rc-typeahead-suggestion
    {:background-color (color :side-bar)}
    [:&.active {:background-color (color :selection)}]]])

(def side-bar
  [:.side-bar {:position :absolute
               :top "0px"
               :right "0px"
               :height "100%"
               :width "300px"
               :background-color (color :side-bar)
               :z-index 10}
   [:.side-bar-tabs {}
    [:li {}
     [:a {:padding "5px"}]
     [:&.active {}
      [:a {:color (color :super-light-grey)
           :background-color (color :side-bar)}]]
     [:a {:color (color :super-light-grey)
          }]]]

   [:.projects-browser {:overflow-y :scroll
                        :height "95%"}
    [:.head-bar {}
     [:.back {:background-color (color :light-grey)
              :margin "5px"}]
     [:.browser-selection {:font-size "11px"
                           :padding "3px"
                           :border-radius border-radius}
      #_[:&.namespaces {:background-color (color :project-node)}]
      #_[:&.vars {:background-color (color :namespace-node)}]]]]

   [:.selected-browser {:overflow-y :scroll
                        :height "95%"}
    [:.header {:font-weight :bold
               :margin-left "5px"}]]])

;; This creates resources/public/css/main.css
(def ^:garden main
  (list
   diagram
   general
   entity-selector
   side-bar))