git add .
git commit -m cc
git push origin master
if test 'github' = $1; then
git push origin-github master
fi