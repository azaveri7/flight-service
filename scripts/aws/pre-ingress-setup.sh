eksctl utils associate-iam-oidc-provider \
    --region us-east-2 \
    --cluster paathshala \
    --approve

curl -o iam-policy.json https://raw.githubusercontent.com/kubernetes-sigs/aws-load-balancer-controller/main/docs/install/iam_policy.json
aws iam create-policy \
    --policy-name AWSLoadBalancerControllerIAMPolicy \
    --policy-document file://iam-policy.json

eksctl create iamserviceaccount \
  --cluster=paathshala \
  --namespace=kube-system \
  --name=aws-load-balancer-controller \
  --attach-policy-arn=arn:aws:iam::615360450654:policy/AWSLoadBalancerControllerIAMPolicy \
  --override-existing-serviceaccounts \
  --approve

curl -o iam_policy_v1_to_v2_additional.json https://raw.githubusercontent.com/kubernetes-sigs/aws-load-balancer-controller/main/docs/install/iam_policy_v1_to_v2_additional.json

aws iam create-policy \
  --policy-name AWSLoadBalancerControllerAdditionalIAMPolicy \
  --policy-document file://iam_policy_v1_to_v2_additional.json

aws iam attach-role-policy \
  --role-name eksctl-attractive-gopher-addon-iamserviceacc-Role1-1CKATS0RA1YFC \
  --policy-arn=arn:aws:iam::615360450654:policy/AWSLoadBalancerControllerAdditionalIAMPolicy

kubectl apply --validate=false -f https://github.com/jetstack/cert-manager/releases/download/v1.0.2/cert-manager.yaml

curl -o v2_0_0_full.yaml https://raw.githubusercontent.com/kubernetes-sigs/aws-load-balancer-controller/main/docs/install/v2_0_0_full.yaml

kubectl apply -f v2_0_0_full.yaml

kubectl get deployment -n kube-system aws-load-balancer-controller

